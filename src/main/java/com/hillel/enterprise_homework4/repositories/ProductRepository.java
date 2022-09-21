package com.hillel.enterprise_homework4.repositories;

import com.hillel.enterprise_homework4.models.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {
}
