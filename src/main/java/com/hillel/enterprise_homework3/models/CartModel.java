package com.hillel.enterprise_homework3.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class CartModel {

    private static final AtomicInteger idCounter = new AtomicInteger(0);

    private final Integer cartId;

    @Setter
    private Integer ownerId;

    @Setter
    private BigDecimal sum = new BigDecimal("0.0");

    private final List<ProductModel> products = new ArrayList<>();

    public CartModel(Integer ownerId) {
        this.cartId = idCounter.incrementAndGet();
        this.ownerId = ownerId;
    }
}
