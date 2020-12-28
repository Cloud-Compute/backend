package com.hive.sell.controller;


import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    IItemService iItemService;

    @RequestMapping("api/getAllItems")
    public DataResult getAll() {

        return DataResult.build(iItemService.getAll());
    }

    @RequestMapping("api/getItem")
    public DataResult getItem(@RequestParam int id) {
        return DataResult.build(iItemService.getById(id));
    }

}
