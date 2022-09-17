package com.hillel.enterprise_homework3.exceptions;

import com.hillel.enterprise_homework3.repositories.CartRepository;
import com.hillel.enterprise_homework3.repositories.PersonRepository;
import com.hillel.enterprise_homework3.repositories.ProductRepository;

public class NotFoundException extends Exception {

    public NotFoundException(CartRepository repository, Integer id) {
        super("Cart with id " + id + " is not exist");
    }

    public NotFoundException(ProductRepository repository, Integer id) {
        super("Product with id " + id + " is not exist");
    }

    public NotFoundException(PersonRepository repository, Integer id) {
        super("Person with id " + id + " is not exist");
    }

    public NotFoundException(ProductRepository repository, String name) {
        super("Product with name " + name + " is not exist");
    }
}
