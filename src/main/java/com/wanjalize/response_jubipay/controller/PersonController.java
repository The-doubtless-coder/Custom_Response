package com.wanjalize.response_jubipay.controller;

import com.wanjalize.response_jubipay.model.Person;
import com.wanjalize.response_jubipay.response.ApiResponse;
import com.wanjalize.response_jubipay.service.PersonServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wanjalize.response_jubipay.request.PersonRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/persons")
@AllArgsConstructor
public class PersonController {

    private final PersonServiceI personServiceI;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> createPerson(@RequestBody PersonRequest request){
        Person person = personServiceI.createPerson(request);
        return ResponseEntity.ok(ApiResponse.success(person));
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
    value = "/{personID}")
    public ResponseEntity<ApiResponse> getPerson(@PathVariable(required = true, value = "personID")
                                                     int Id) {
        Optional<Person> byId = personServiceI.findById(Id);
        if(byId.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.errorPassStatus(
                    "person with ID::" + Id + " does not exist",
                    HttpStatus.CONFLICT
            ));
        }else return ResponseEntity.ok(ApiResponse.success(byId.get()));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getAllPerson(){
        Optional<List<Person>> all = personServiceI.findAll();
        if(all.isEmpty()){
            return ResponseEntity.ok(ApiResponse.successPassCustomMessageStatusAndCode(
                    HttpStatus.NO_CONTENT,
                    HttpStatus.NO_CONTENT.value(),
                    "list is empty",
                    null
            ));
        }else return ResponseEntity.ok(ApiResponse.success(all.get()));
    }
}
