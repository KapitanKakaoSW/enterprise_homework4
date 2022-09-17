package com.hillel.enterprise_homework3.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class PersonModel {

    private static final AtomicInteger idCounter = new AtomicInteger(0);

    private final Integer personId;

    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String phoneNumber;
    @Setter
    private String email;

    private final List<CartModel> carts = new ArrayList<>();

    public PersonModel(String firstName, String lastName, String phoneNumber, String email) {
        this.personId = idCounter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
