package com.hillel.enterprise_homework4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @ManyToOne
    private PersonModel person;

    @OneToMany(orphanRemoval = true)
    @JoinColumn
    private List<ProductModel> products = new ArrayList<>();

    private BigDecimal sum = new BigDecimal("0.0");

    public CartModel(PersonModel person) {
        this.person = person;
    }
}
