package com.hive.sell.controller;

import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.GlobalResult.TimeDataResult;
import com.hive.sell.pojo.Item;
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

    // 获取所有订单
    @GetMapping("api/getAllOrders")
    public DataResult getAll() {
        return DataResult.build(iOrderService.getAll());
    }

    // 获取销售总额最大的订单
    @GetMapping("/api/getTopSellingItem")
    public DataResult getTopItem() {
        List<Number> maxVals = iOrderService.getTopItem();
        List<Item> items = new ArrayList<>();
        for (int i=1; i< maxVals.size(); ++i) {
            Item item = iItemService.getById(maxVals.get(i));
            item.setTotal((Double)maxVals.get(0));
            items.add(item);
        }
        return DataResult.build(items);
    }

    // 获取消费额最大的用户
    @GetMapping("/api/getBestCustomer")
    public DataResult getTopUser() {
        List<Number> maxVals = iOrderService.getTopUser();
        List<User> users = new ArrayList<>();
        for (int i=1; i< maxVals.size(); ++i) {
            User user = iUserService.getById(maxVals.get(i));
            user.setTotal((Double)maxVals.get(0));
            users.add(user);
        }
        return DataResult.build(users);
    }

    // 商品销售额统计，每日总额
    @GetMapping("/api/getSalesAnalysisByItem")
    public TimeDataResult getTotalByItem(@RequestParam String startTime,
                                         @RequestParam String endTime,
                                         @RequestParam int itemId) {
        return TimeDataResult.build(startTime, endTime,
                iOrderService.getTotalByItem(startTime, endTime, itemId));
    }

    // 用户购买额统计，每日总额
    @GetMapping("api/getSalesAnalysisByUser")
    public TimeDataResult getTotalByUser(@RequestParam String startTime,
                                         @RequestParam String endTime,
                                         @RequestParam int userId) {
        return TimeDataResult.build(startTime, endTime,
                iOrderService.getTotalByUser(startTime, endTime, userId));
    }

    // 商品销售统计，每日总额
    @GetMapping("api/getSalesAnalysis")
    public TimeDataResult getSalesAnalysis(@RequestParam String startTime, @RequestParam String endTime) {

        return TimeDataResult.build(startTime, endTime,
                iOrderService.getTotalByTime(startTime, endTime));
    }
}
