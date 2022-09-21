package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.dtos.ProductDTO;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ProductModel;

import java.util.Collection;

public interface ProductService {

    void addProduct(ProductDTO productDTO) throws ShopNotFoundException;

    Collection<ProductModel> getAllProducts();

    ProductModel getProductById(Integer id) throws ProductNotFoundException;

    void updateProductById(Integer id, ProductDTO productDTO) throws ProductNotFoundException, ShopNotFoundException;

    void removeProductById(Integer id) throws ProductNotFoundException;

}
