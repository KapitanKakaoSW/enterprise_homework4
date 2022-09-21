package com.hillel.enterprise_homework4.repositories;

import com.hillel.enterprise_homework4.models.ShopModel;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopModel, Integer> {
}
