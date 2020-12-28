package com.hive.sell.service;

import com.hive.sell.pojo.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAll();

    /**
     *
     * @return 销量最高的商品
     */
    List<Integer> getTopItem();


}
