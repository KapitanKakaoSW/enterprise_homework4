package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ShopModel;
import com.hillel.enterprise_homework4.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void createShop(String name) {
        ShopModel shop = new ShopModel(name);
        shopRepository.save(shop);
    }

    @Override
    public Collection<ShopModel> getAllShops() {
        return (List<ShopModel>) shopRepository.findAll();
    }

    @Override
    public ShopModel getShopById(Integer id) throws ShopNotFoundException {
        if (shopRepository.findById(id).isPresent()) {
            return shopRepository.findById(id).get();
        } else {
            throw new ShopNotFoundException(id);
        }
    }

    @Override
    public void clearShop(Integer id) throws ShopNotFoundException {
        if (shopRepository.findById(id).isPresent()) {
            ShopModel shop = shopRepository.findById(id).get();
            shop.getProducts().clear();
            shopRepository.save(shop);
        } else {
            throw new ShopNotFoundException(id);
        }
    }

    @Override
    public void deleteShopById(Integer id) throws ShopNotFoundException {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
        } else {
            throw new ShopNotFoundException(id);
        }
    }
}
