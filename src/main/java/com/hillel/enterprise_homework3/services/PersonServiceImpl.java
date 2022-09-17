package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.dtos.PersonDTO;
import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.PersonModel;
import com.hillel.enterprise_homework3.repositories.PersonRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(@NonNull PersonDTO personDTO) {
        PersonModel person = new PersonModel(
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.getPhoneNumber(),
                personDTO.getEmail());
        personRepository.getPersons().put(person.getPersonId(), person);
    }

    @Override
    public Collection<PersonModel> getAllPersons() {
        return personRepository.getPersons().values();
    }

    @Override
    public PersonModel getPersonById(@NonNull Integer id) throws NotFoundException {
        if (personRepository.getPersons().containsKey(id)) {
            return personRepository.getPersons().get(id);
        } else {
            throw new NotFoundException("Person with id " + id + " is not exist");
        }
    }

    @Override
    public void deletePersonById(@NonNull Integer id) throws NotFoundException {
        if (personRepository.getPersons().containsKey(id)) {
            personRepository.getPersons().remove(id);
        } else {
            throw new NotFoundException("Person with id " + id + " is not exist");
        }
    }
}
