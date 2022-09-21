package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.exceptions.CartNotFoundException;
import com.hillel.enterprise_homework4.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.models.CartModel;
import com.hillel.enterprise_homework4.repositories.CartRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductService productService;

    private final PersonService personService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService, PersonService personService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public void createCart(Integer id) throws PersonNotFoundException {
        CartModel cart = new CartModel(personService.getPersonById(id));
        personService.getPersonById(id).getCarts().add(cart);
        cartRepository.save(cart);
    }

    @Override
    public CartModel getCart(Integer id) throws CartNotFoundException {
        if (cartRepository.findById(id).isPresent()){
            return cartRepository.findById(id).get();
        } else {
            throw new CartNotFoundException(id);
        }
    }

    @Override
    public void addProductByProductIdAndCartId(Integer productId, Integer cartId)
            throws CartNotFoundException, ProductNotFoundException {

       if (cartRepository.findById(cartId).isPresent()) {
           CartModel cart = cartRepository.findById(cartId).get();

           cart.getProducts().add(productService.getProductById(productId));
           cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getProductById(productId).getProductPrice())));
           cartRepository.save(cart);
       } else {
           throw new CartNotFoundException(cartId);
       }
    }

    @Override
    public void removeProductByProductIdAndCartId(Integer productId, @NonNull Integer cartId)
            throws CartNotFoundException, ProductNotFoundException {

        if (cartRepository.findById(cartId).isPresent()) {
            CartModel cart = cartRepository.findById(cartId).get();

            cart.getProducts().remove(productService.getProductById(productId));
            cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getProductById(productId).getProductPrice())));
            cartRepository.save(cart);
        } else {
            throw new CartNotFoundException(cartId);
        }
    }

    @Override
    public void removeAllProductsByCartId(Integer id) throws CartNotFoundException {
        if (cartRepository.findById(id).isPresent()) {
            CartModel cart = cartRepository.findById(id).get();
            cart.getProducts().clear();
            cartRepository.findById(id).get().setSum(new BigDecimal("0.00"));
            cartRepository.save(cart);
        } else {
            throw new CartNotFoundException(id);
        }
    }

    @Override
    public void removeCartById(Integer id) throws CartNotFoundException, PersonNotFoundException {
        if (cartRepository.findById(id).isPresent()) {
            CartModel cart = cartRepository.findById(id).get();
            personService.getPersonById(cart.getPerson().getPersonId()).getCarts().remove(cart);
            cartRepository.deleteById(id);
        } else {
            throw new CartNotFoundException(id);
        }
    }
}
