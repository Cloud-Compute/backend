package com.hive.sell.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hive.sell.dao.OrderMapper;
import com.hive.sell.pojo.Order;
import com.hive.sell.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }

    @Override
    public List<Integer> getTopItem() {
//        QueryWrapper<Order> query = new QueryWrapper<>();
//        query.select("sum(payment) as total, itemID")
//                .groupBy("ItemID")
//                .orderByDesc("total");
//        List<Map<String, Object>> orders = orderMapper.selectMaps(query);
//        System.out.println(orders);
        return null;
    }
}
