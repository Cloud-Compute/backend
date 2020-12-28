package com.hive.sell.controller;


import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.pojo.Item;
import com.hive.sell.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    IItemService iItemService;

    @RequestMapping("api/getAllItems")
    public DataResult getAll() {

        return DataResult.build(iItemService.getAll());
    }

//    @RequestMapping("api/getItem")
    public DataResult getItem(@RequestParam int id) {
        return DataResult.build(iItemService.getById(id));
//        return DataResult.build(iItemService.getOneById(id));
    }

//    @RequestMapping("api/getTopSellingItem")
    public Item getTop() {return null;}

}
