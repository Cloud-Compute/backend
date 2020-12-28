package com.hive.sell.controller;

import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @GetMapping("api/getAllOrders")
    public List<Order> getAll() {
        return iOrderService.getAll();
    }

    @GetMapping("/api/getTopSellingItem")
    public List<Item> getTopItem() {
        iOrderService.getTopItem();
        return null;
    }
}
