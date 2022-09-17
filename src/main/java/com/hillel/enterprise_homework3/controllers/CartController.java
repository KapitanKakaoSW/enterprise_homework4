package com.hillel.enterprise_homework3.controllers;

import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.CartModel;
import com.hillel.enterprise_homework3.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;


    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addCart(@RequestParam Integer id) {
        cartService.createCart(id);
        return new ResponseEntity<>("Cart with id " + id + " is created", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<CartModel>> getAllCartsByPersonId(@RequestParam Integer id) throws NotFoundException {
        return new ResponseEntity<>(cartService.getAllCartsByPersonId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cart")
    public ResponseEntity<CartModel> getCartById(@RequestParam Integer id) throws NotFoundException {
        return new ResponseEntity<>(cartService.getCart(id), HttpStatus.OK);
    }

    @PutMapping(value = "/cart_{cartId}/add")
    public ResponseEntity<String> addProductByProductIdAndCartId(@PathVariable Integer cartId,
                                                                 @RequestParam Integer productId)
            throws NotFoundException {
        cartService.addProductByProductIdAndCartId(productId, cartId);
        return new ResponseEntity<>("Successfully added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/cart_{cartId}/remove")
    public ResponseEntity<String> removeProductByProductIdAndCartId(@PathVariable Integer cartId,
                                                                    @RequestParam Integer productId)
            throws NotFoundException {
        cartService.removeProductByProductIdAndCartId(productId, cartId);
        return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<String> removeAllProductsByCartId(@RequestParam Integer id) throws NotFoundException {
        cartService.removeAllProductsByCartId(id);
        return new ResponseEntity<>("Successfully removed",HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> removeCartById(@RequestParam Integer id) throws NotFoundException {
        cartService.removeCartById(id);
        return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
    }

    @DeleteMapping(value = "/person_remove")
    public ResponseEntity<String> removeAllCartsByPersonId(@RequestParam Integer id) throws NotFoundException {
        cartService.removeAllCartsByPersonId(id);
        return new ResponseEntity<>("Successfully removed", HttpStatus.OK);
    }
}
