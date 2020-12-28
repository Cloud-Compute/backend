package com.hive.sell.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hive.sell.dao.OrderMapper;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.pojo.User;
import com.hive.sell.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }

    public List<Order> getOrderByItemId(int itemId) {
        QueryWrapper<Order> query = new QueryWrapper<>();
        query.eq("itemId", itemId);
        return orderMapper.selectList(query);
    }


    public List<Item> getTopItem() {
//        QueryWrapper<Order> query = new QueryWrapper<>();
//        query.select("sum(payment) as total, itemID")
//                .groupBy("ItemID")
//                .orderByDesc("total");
//        List<Map<String, Object>> orders = orderMapper.selectMaps(query);
//        System.out.println(orders);
        List<Item> items = orderMapper.findTopItem();
        return items;
    }

    public List<User> getTopUser() {
        List<User> users = orderMapper.findTopUser();
        return users;
    }

    public List<Order> getOrderByTime(Date start, Date end, int itemId) {
        List<Order> orders = this.getOrderByItemId(itemId);
        List<Order> result = new LinkedList<>();
        for (Order order : orders) {
            Date time = new Date(order.getOrderTime());
            if (time.after(start) && time.before(end)) result.add(order);
        }
        return result;
    }
}
