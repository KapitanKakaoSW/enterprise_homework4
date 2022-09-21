package com.hillel.enterprise_homework4.dtos;

import lombok.Data;

@Data
public class ProductDTO {

    private String productName;
    private String productDescription;
    private Double price;
    private Integer shopId;
}
