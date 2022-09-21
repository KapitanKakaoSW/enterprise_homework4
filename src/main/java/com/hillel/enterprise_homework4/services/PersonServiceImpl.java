package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.dtos.PersonDTO;
import com.hillel.enterprise_homework4.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework4.models.CartModel;
import com.hillel.enterprise_homework4.models.PersonModel;
import com.hillel.enterprise_homework4.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void addPerson(PersonDTO personDTO) {
        PersonModel person = new PersonModel(
                personDTO.getFirstName(),
                personDTO.getLastName(),
                personDTO.getPhoneNumber(),
                personDTO.getEmail());
        personRepository.save(person);
    }

    @Override
    public Collection<PersonModel> getAllPersons() {
        return (List<PersonModel>) personRepository.findAll();
    }

    @Override
    public PersonModel getPersonById(Integer id) throws PersonNotFoundException {
        if (personRepository.findById(id).isPresent()) {
            return personRepository.findById(id).get();
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    @Override
    public void updatePersonById(Integer id, PersonDTO personDTO) throws PersonNotFoundException {
        if (personRepository.findById(id).isPresent()) {
            PersonModel person = personRepository.findById(id).get();
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setPhoneNumber(personDTO.getPhoneNumber());
            person.setEmail(personDTO.getEmail());
            personRepository.save(person);
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    @Override
    public void removeAllCartsByPersonId(Integer id) throws PersonNotFoundException {
        if (personRepository.findById(id).isPresent()) {
            PersonModel person = personRepository.findById(id).get();
            person.getCarts().clear();
            personRepository.save(person);
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    @Override
    public void deletePersonById(Integer id) throws PersonNotFoundException {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new PersonNotFoundException(id);
        }
    }

    public Collection<CartModel> getAllCartsByPersonId(Integer id) throws PersonNotFoundException {
        if (personRepository.findById(id).isPresent()) {
            return personRepository.findById(id).get().getCarts();
        } else {
            throw new PersonNotFoundException(id);
        }
    }
}
