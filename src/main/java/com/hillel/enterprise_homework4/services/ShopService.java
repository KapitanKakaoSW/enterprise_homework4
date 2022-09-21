package com.hillel.enterprise_homework4.services;

import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ShopModel;

import java.util.Collection;

public interface ShopService {

    void createShop(String name);

    Collection<ShopModel> getAllShops();

    ShopModel getShopById(Integer id) throws ShopNotFoundException;

    void clearShop(Integer id) throws ShopNotFoundException;

    void deleteShopById(Integer id) throws ShopNotFoundException;
}
