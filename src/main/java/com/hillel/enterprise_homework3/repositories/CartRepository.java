package com.hillel.enterprise_homework3.repositories;

import com.hillel.enterprise_homework3.models.CartModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class CartRepository {
    private final Map<Integer, CartModel> carts = new HashMap<>();
}
