package com.hive.sell.controller;


import com.hive.sell.pojo.Item;
import com.hive.sell.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    IItemService iItemService;

    @RequestMapping("api/getAllItems")
    List<Item> getAll() {
        return iItemService.getAll();
    }

}
