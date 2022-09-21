package com.hillel.enterprise_homework4.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Integer id) {
        super("Person with id " + id + " is not exist");
    }
}
