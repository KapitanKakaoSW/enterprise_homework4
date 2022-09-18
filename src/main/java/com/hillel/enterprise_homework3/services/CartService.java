package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.exceptions.CartNotFoundException;
import com.hillel.enterprise_homework3.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework3.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework3.models.CartModel;

import java.util.Collection;

public interface CartService {

    void createCart(Integer id);

    Collection<CartModel> getAllCartsByPersonId(Integer id) throws CartNotFoundException;

    CartModel getCart(Integer id) throws CartNotFoundException;

    void addProductByProductIdAndCartId(Integer productId, Integer CartId) throws CartNotFoundException, ProductNotFoundException;

    void removeProductByProductIdAndCartId(Integer productId, Integer cartId) throws CartNotFoundException, ProductNotFoundException;

    void removeAllProductsByCartId(Integer id) throws CartNotFoundException;

    void removeCartById(Integer id) throws CartNotFoundException;

    void removeAllCartsByPersonId(Integer id) throws PersonNotFoundException;
}
