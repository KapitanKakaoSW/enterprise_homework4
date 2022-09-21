package com.hillel.enterprise_homework4.controllers;

import com.hillel.enterprise_homework4.exceptions.CartNotFoundException;
import com.hillel.enterprise_homework4.exceptions.PersonNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.models.CartModel;
import com.hillel.enterprise_homework4.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addCart(@RequestParam Integer id) throws PersonNotFoundException {
        cartService.createCart(id);
        return new ResponseEntity<>("Cart added to person with id  " + id, HttpStatus.OK);
    }

    @GetMapping(value = "/cart")
    public ResponseEntity<CartModel> getCartById(@RequestParam Integer id) throws CartNotFoundException {
        return new ResponseEntity<>(cartService.getCart(id), HttpStatus.OK);
    }

    @PutMapping(value = "/cart_{cartId}/add")
    public ResponseEntity<String> addProductByProductIdAndCartId(@PathVariable Integer cartId,
                                                                 @RequestParam Integer productId)
            throws CartNotFoundException, ProductNotFoundException {
        cartService.addProductByProductIdAndCartId(productId, cartId);
        return new ResponseEntity<>("Successfully added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/cart_{cartId}/remove")
    public ResponseEntity<String> removeProductByProductIdAndCartId(@PathVariable Integer cartId,
                                                                    @RequestParam Integer productId)
            throws CartNotFoundException, ProductNotFoundException {
        cartService.removeProductByProductIdAndCartId(productId, cartId);
        return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<String> removeAllProductsByCartId(@RequestParam Integer id) throws CartNotFoundException {
        cartService.removeAllProductsByCartId(id);
        return new ResponseEntity<>("Successfully clear",HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> removeCartById(@RequestParam Integer id) throws CartNotFoundException, PersonNotFoundException {
        cartService.removeCartById(id);
        return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
    }
}
