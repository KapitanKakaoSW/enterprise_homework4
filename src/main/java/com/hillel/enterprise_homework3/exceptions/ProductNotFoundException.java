package com.hillel.enterprise_homework3.exceptions;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(Integer id) {
        super("Product with id " + id + " is not exist");
    }

    public ProductNotFoundException(String name) {
        super("Product with name " + name + " is not exist");
    }
}
