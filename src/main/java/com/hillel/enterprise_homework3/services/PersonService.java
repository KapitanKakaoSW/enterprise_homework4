package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.dtos.PersonDTO;
import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.PersonModel;

import java.util.Collection;

public interface PersonService {

    void addPerson(PersonDTO personDTO);

    Collection<PersonModel> getAllPersons();

    PersonModel getPersonById(Integer id) throws NotFoundException;

    void deletePersonById(Integer id) throws NotFoundException;
}
