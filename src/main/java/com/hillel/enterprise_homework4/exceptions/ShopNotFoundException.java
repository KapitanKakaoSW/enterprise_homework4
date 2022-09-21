package com.hillel.enterprise_homework4.exceptions;

public class ShopNotFoundException extends Exception {

    public ShopNotFoundException(Integer id) {
        super("Shop with name " + id + " is not exist");
    }
}
