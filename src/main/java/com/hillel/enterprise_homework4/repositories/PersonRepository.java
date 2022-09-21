package com.hillel.enterprise_homework4.repositories;

import com.hillel.enterprise_homework4.models.PersonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonModel, Integer> {
}
