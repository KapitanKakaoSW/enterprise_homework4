package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.dtos.ProductDTO;
import com.hillel.enterprise_homework3.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework3.models.ProductModel;

import java.util.Collection;

public interface ProductService {

    void addProduct(ProductDTO productDTO);

    Collection<ProductModel> getAllProducts();

    ProductModel getProductById(Integer id) throws ProductNotFoundException;

    Collection<ProductModel> getProductByName(String name) throws ProductNotFoundException;

    void updateProductById(Integer id, ProductDTO productDTO) throws ProductNotFoundException;

    void removeProductById(Integer id) throws ProductNotFoundException;

}
