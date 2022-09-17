package com.hillel.enterprise_homework3.models;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class ProductModel {

    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final Integer productId;

    @Setter
    private String productName;
    @Setter
    private String productDescription;
    @Setter
    private Double productPrice;

    public ProductModel(String productName, String productDescription, Double productPrice) {
        this.productId = idCounter.incrementAndGet();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }
}