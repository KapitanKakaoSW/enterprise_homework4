package com.hillel.enterprise_homework3.repositories;

import com.hillel.enterprise_homework3.models.ProductModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class ProductRepository {
    private final Map<Integer, ProductModel> products = new HashMap<>();
}
