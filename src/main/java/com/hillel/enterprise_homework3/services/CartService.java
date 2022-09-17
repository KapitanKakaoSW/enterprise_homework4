package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.CartModel;

import java.util.Collection;

public interface CartService {

    void createCart(Integer id);

    Collection<CartModel> getAllCartsByPersonId(Integer id) throws NotFoundException;

    CartModel getCart(Integer id) throws NotFoundException;

    void addProductByProductIdAndCartId(Integer productId, Integer CartId) throws NotFoundException;

    void removeProductByProductIdAndCartId(Integer productId, Integer cartId) throws NotFoundException;

    void removeAllProductsByCartId(Integer id) throws NotFoundException;

    void removeCartById(Integer id) throws NotFoundException;

    void removeAllCartsByPersonId(Integer id) throws NotFoundException;
}
