package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.dtos.ProductDTO;
import com.hillel.enterprise_homework4.exceptions.ProductNotFoundException;
import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ProductModel;
import com.hillel.enterprise_homework4.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ShopService shopService;

    public ProductServiceImpl(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    @Override
    public void addProduct(ProductDTO productDTO) throws ShopNotFoundException {
        ProductModel product = new ProductModel(
                productDTO.getProductName(),
                productDTO.getProductDescription(),
                productDTO.getPrice());
        product.setShop(shopService.getShopById(productDTO.getShopId()));
        shopService.getShopById(productDTO.getShopId()).getProducts().add(product);
        productRepository.save(product);
    }

    @Override
    public Collection<ProductModel> getAllProducts() {
        return (List<ProductModel>) productRepository.findAll();
    }

    @Override
    public ProductModel getProductById(Integer id) throws ProductNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public void updateProductById(Integer id, ProductDTO productDTO) throws ProductNotFoundException, ShopNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            ProductModel product = productRepository.findById(id).get();
            shopService.getShopById(product.getShop().getId()).getProducts().remove(product);
            product.setProductName(productDTO.getProductName());
            product.setProductDescription(productDTO.getProductDescription());
            product.setProductPrice(productDTO.getPrice());
            product.setShop(shopService.getShopById(productDTO.getShopId()));
            shopService.getShopById(productDTO.getShopId()).getProducts().add(product);
            productRepository.save(product);
        } else  {
            throw new ProductNotFoundException(id);
        }
    }

    @Override
    public void removeProductById(Integer id) throws ProductNotFoundException {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException(id);
        }
    }
}
