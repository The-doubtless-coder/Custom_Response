package com.wanjalize.response_jubipay.service;

import com.wanjalize.response_jubipay.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import request.PersonRequest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceI {
    private List<Person> personList = new ArrayList<>();
    @Override
    public Person createPerson(PersonRequest personRequest) {
        if(personList.isEmpty()){
            personList.add(new Person(1, personRequest.getName(),
                    personRequest.getAge(),
                    personRequest.getPlaceOfBirth(),
                    personRequest.getOccupation()));
            return personList.get(0);
        }else {
            int personID = personList.stream().max(Comparator.comparingLong(Person::getPersonID)).get().getPersonID();
            personList.add(new Person(personID + 1,
                    personRequest.getName(),
                    personRequest.getAge(),
                    personRequest.getPlaceOfBirth(),
                    personRequest.getOccupation()));
            return personList.get(personID);
        }
    }

    @Override
    public Optional<Person> findById(int Id) {
            return personList.stream().filter(p ->p.getPersonID() == Id).findAny();
    }

    @Override
    public Optional<List<Person>> findAll() {
        return  personList.isEmpty() ? Optional.empty(): Optional.of(personList);
    }
    @PostConstruct
    private void populateList(){
        personList.add(new Person(1, "ken", 21, "naks", "singer"));
        personList.add(new Person(2, "james", 19,"kanairo", "coder"));
        personList.add(new Person(3, "edu", 35, "germany", "painter"));
        personList.add(new Person(4, "junior", 35, "us", "instructor" ));
        personList.add(new Person(5, "makori", 43, "ug","student"));
    }
}
