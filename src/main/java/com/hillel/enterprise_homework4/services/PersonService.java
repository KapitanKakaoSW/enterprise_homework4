package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.dtos.PersonDTO;
import com.hillel.enterprise_homework4.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework4.models.CartModel;
import com.hillel.enterprise_homework4.models.PersonModel;

import java.util.Collection;

public interface PersonService {

    void addPerson(PersonDTO personDTO);

    Collection<PersonModel> getAllPersons();

    Collection<CartModel> getAllCartsByPersonId(Integer id) throws PersonNotFoundException;

    PersonModel getPersonById(Integer id) throws PersonNotFoundException;

    void updatePersonById(Integer id, PersonDTO personDTO) throws PersonNotFoundException;

    void removeAllCartsByPersonId(Integer id) throws PersonNotFoundException;

    void deletePersonById(Integer id) throws PersonNotFoundException;
}
