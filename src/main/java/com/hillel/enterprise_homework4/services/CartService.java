package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.exceptions.CartNotFoundException;
import com.hillel.enterprise_homework4.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.models.CartModel;

public interface CartService {

    void createCart(Integer id) throws PersonNotFoundException;

    CartModel getCart(Integer id) throws CartNotFoundException;

    void addProductByProductIdAndCartId(Integer productId, Integer CartId)
            throws CartNotFoundException, ProductNotFoundException;

    void removeProductByProductIdAndCartId(Integer productId, Integer cartId)
            throws CartNotFoundException, ProductNotFoundException;

    void removeAllProductsByCartId(Integer id) throws CartNotFoundException;

    void removeCartById(Integer id) throws CartNotFoundException, PersonNotFoundException;
}
