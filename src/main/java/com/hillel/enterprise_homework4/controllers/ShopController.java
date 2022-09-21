package com.hillel.enterprise_homework4.controllers;

import com.hillel.enterprise_homework4.exceptions.ShopNotFoundException;
import com.hillel.enterprise_homework4.models.ShopModel;
import com.hillel.enterprise_homework4.services.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> createShop(@RequestBody String name) {
        shopService.createShop(name);
        return new ResponseEntity<>("Shop with name: " + name + " is created", HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<ShopModel>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @GetMapping(value = "/shop")
    public ResponseEntity<ShopModel> getShopById(@RequestParam Integer id) throws ShopNotFoundException {
        return new ResponseEntity<>(shopService.getShopById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/clear")
    public ResponseEntity<String> clearShop(@RequestParam Integer id) throws ShopNotFoundException {
        shopService.clearShop(id);
        return new ResponseEntity<>("Shop with id " + id + " successfully cleared", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteShopById(@RequestParam Integer id) throws ShopNotFoundException {
        shopService.deleteShopById(id);
        return new ResponseEntity<>("Shop with id " + id + " successfully cleared", HttpStatus.OK);
    }
}
