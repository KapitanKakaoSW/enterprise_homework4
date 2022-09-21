package com.hillel.enterprise_homework4.repositories;

import com.hillel.enterprise_homework4.models.CartModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartModel, Integer> {

}
