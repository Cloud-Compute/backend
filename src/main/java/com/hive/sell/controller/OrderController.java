package com.hive.sell.controller;

import com.hive.sell.repository.ItemDao;
import com.hive.sell.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/api/getAllOrders")
    public List<Map<String, Object>> getAllOrders() {
        return orderDao.getAll();
    }
}
