package com.hillel.enterprise_homework4.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Integer id) {
        super("Product with id " + id + " is not exist");
    }

}
