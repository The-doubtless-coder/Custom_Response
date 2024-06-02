package com.wanjalize.response_jubipay.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int personID;
    private String name;
    private int age;
    private String placeOfBirth;
    private String occupation;
}
