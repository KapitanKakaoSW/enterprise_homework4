package com.hillel.enterprise_homework4.controllers;

import com.hillel.enterprise_homework4.dtos.ProductDTO;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ProductModel;
import com.hillel.enterprise_homework4.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) throws ShopNotFoundException {
        service.addProduct(productDTO);
        return new ResponseEntity<>(productDTO.getProductName() + " is created", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<ProductModel>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<ProductModel> getProductById(@RequestParam Integer id)
            throws ProductNotFoundException {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateProductById(@RequestParam Integer id, @RequestBody ProductDTO productDTO)
            throws ProductNotFoundException, ShopNotFoundException {
        service.updateProductById(id, productDTO);
        return new ResponseEntity<>("Product with id " + id + " is updated", HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> removeProductById(@RequestParam Integer id) throws ProductNotFoundException {
        service.removeProductById(id);
        return new ResponseEntity<>("Product with id " + id + " is deleted", HttpStatus.OK);
    }
}
