package com.hillel.enterprise_homework4.exceptions;

public class CartNotFoundException extends Exception {

    public CartNotFoundException(Integer id) {
        super("Cart with id " + id + " is not exist");
    }
}
