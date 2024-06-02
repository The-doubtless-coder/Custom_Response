package com.wanjalize.response_jubipay.service;

import com.wanjalize.response_jubipay.model.Person;
import com.wanjalize.response_jubipay.request.PersonRequest;

import java.util.List;
import java.util.Optional;

public interface PersonServiceI {

    public Person createPerson(PersonRequest personRequest);
    public Optional<Person> findById(int id);
    public Optional<List<Person>> findAll();
}
