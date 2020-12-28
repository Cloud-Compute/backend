package com.hive.sell.controller;

import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.pojo.User;
import com.hive.sell.service.IItemService;
import com.hive.sell.service.IOrderService;
import com.hive.sell.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    @Autowired
    IItemService iItemService;

    @Autowired
    IUserService iUserService;

    @GetMapping("api/getAllOrders")
    public DataResult getAll() {
        return DataResult.build(iOrderService.getAll());
    }

    @GetMapping("/api/getTopSellingItem")
    public List<Item> getTopItem() {
        List<Item> items = iOrderService.getTopItem();
        for (Item item : items) {
//            iItemService
        }
        return items;
    }

    @GetMapping("/api/getBestCustomer")
    public List<User> getTopUser() {
        return iOrderService.getTopUser();
    }

    @GetMapping("/api/getSalesAnalysisByItem")
    public List<Order> getOrderByTime(@RequestParam Date start_time,
                                      @RequestParam Date end_time,
                                      @RequestParam int itemId) {
        return iOrderService.getOrderByTime(start_time, end_time, itemId);
    }
}
