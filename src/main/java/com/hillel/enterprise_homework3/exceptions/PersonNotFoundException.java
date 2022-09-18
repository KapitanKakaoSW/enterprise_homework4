package com.hillel.enterprise_homework3.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(Integer id) {
        super("Person with id " + id + " is not exist");
    }
}
