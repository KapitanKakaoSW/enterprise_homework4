package com.hillel.enterprise_homework3.controllers;

import com.hillel.enterprise_homework3.dtos.ProductDTO;
import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.ProductModel;
import com.hillel.enterprise_homework3.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        service.addProduct(productDTO);
        return new ResponseEntity<>( productDTO.getProductName() + " is created", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<ProductModel>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<ProductModel> getProductById(@RequestParam Integer id) throws NotFoundException {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/product_name")
    private ResponseEntity<Collection<ProductModel>> getProductByName(@RequestParam String name) throws NotFoundException {
        return new ResponseEntity<>(service.getProductByName(name), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    public ResponseEntity<String> removeProductById(@RequestParam Integer id) throws NotFoundException {
        service.removeProductById(id);
        return new ResponseEntity<>("Product with" + id + " is deleted", HttpStatus.OK);
    }
}
