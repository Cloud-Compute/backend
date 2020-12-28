package com.hive.sell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.pojo.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOrderService extends IService<Order> {

    List<Order> getAll();
    List<Order> getOrderByItemId(int itemId);

    /* 销量最高的商品 */
    Map<Integer, Double> getTopItem();

    /* 买的最多的用户 */
    List<User> getTopUser();

    /* 某商品某段时间内所有订单 */
    List<Order> getOrderByTime(Date start, Date end, int itemId);

}
