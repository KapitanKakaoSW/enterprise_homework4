package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.dtos.ProductDTO;
import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.ProductModel;
import com.hillel.enterprise_homework3.repositories.ProductRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(@NonNull ProductDTO productDTO) {
        ProductModel product = new ProductModel(
                productDTO.getProductName(),
                productDTO.getProductDescription(),
                productDTO.getPrice());
        productRepository.getProducts().put(product.getProductId(), product);
    }

    @Override
    public Collection<ProductModel> getAllProducts() {
        return productRepository.getProducts().values();
    }

    @Override
    public ProductModel getProductById(@NonNull Integer id) throws NotFoundException {
        if (productRepository.getProducts().containsKey(id)) {
            return productRepository.getProducts().get(id);
        } else {
            throw new NotFoundException("Product with id " + id + " is not exist");
        }
    }

    @Override
    public Collection<ProductModel> getProductByName(@NonNull String name) throws NotFoundException {
        Collection<ProductModel> products = productRepository.getProducts().values()
                .stream().filter(productModel -> productModel.getProductName().equals(name))
                .collect(Collectors.toList());

        if (products.isEmpty()) {
            throw new NotFoundException("Products with name " + name + " is not exists");
        } else {
            return products;
        }
    }

    @Override
    public void removeProductById(@NonNull Integer id) throws NotFoundException {
        if (productRepository.getProducts().containsKey(id)){
            productRepository.getProducts().remove(id);
        } else {
            throw new NotFoundException("Product with id " + id + " is not exist");
        }
    }
}
