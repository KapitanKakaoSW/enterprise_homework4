package com.hillel.enterprise_homework3.repositories;

import com.hillel.enterprise_homework3.models.PersonModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class PersonRepository {
    private final Map<Integer, PersonModel> persons = new HashMap<>();
}
