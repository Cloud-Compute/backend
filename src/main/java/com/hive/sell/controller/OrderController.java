package com.hive.sell.controller;

import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.GlobalResult.TotalDataResult;
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

import java.util.*;


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
    public DataResult getTopItem() {
//        Map<Integer, Double> maxItem = iOrderService.getTopItem();
//        List<Item> items = new ArrayList<>();
//        for (Map.Entry<Integer, Double> e : groupOrder.entrySet()) {

//            Item item = iItemService.getById(e.getKey());
//            item.setTotal(e.getValue());
//            items.add(item);
//        }
//        return DataResult.build(items);
//        Item item = iItemService.getById(maxItem.)

        List<Number> maxVals = iOrderService.getTopItem();
        List<Item> items = new ArrayList<>();
        for (int i=1; i< maxVals.size(); ++i) {
            Item item = iItemService.getById(maxVals.get(i));
            item.setTotal((Double)maxVals.get(0));
            items.add(item);
        }
        return DataResult.build(items);
    }

    @GetMapping("/api/getBestCustomer")
    public DataResult getTopUser() {
//        return iOrderService.getTopUser();
        List<Number> maxVals = iOrderService.getTopUser();
        List<User> users = new ArrayList<>();
        for (int i=1; i< maxVals.size(); ++i) {
            User user = iUserService.getById(maxVals.get(i));
            user.setTotal((Double)maxVals.get(0));
            users.add(user);
        }
        return DataResult.build(users);
    }

//    @GetMapping("/api/getSalesAnalysisByItem")
    public List<Order> getOrderByTime(@RequestParam Date start_time,
                                      @RequestParam Date end_time,
                                      @RequestParam int itemId) {
        return iOrderService.getOrderByTime(start_time, end_time, itemId);

    }
}
