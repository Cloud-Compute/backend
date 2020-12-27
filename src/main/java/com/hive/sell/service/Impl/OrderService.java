package com.hive.sell.service.Impl;

import com.hive.sell.dao.OrderMapper;
import com.hive.sell.pojo.Order;
import com.hive.sell.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }
}
