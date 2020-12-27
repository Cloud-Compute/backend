package com.hive.sell.controller;

import com.hive.sell.repository.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/api/getAllItems")
    public List<Map<String, Object>> getAllItems() {
        return itemDao.getAll();
    }
}
