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

    /* 销量最高的商品 */
    List<Number> getTopItem();

    /* 买的最多的用户 */
    List<Number> getTopUser();

    // 某段时间内所有订单
    List<Order> getOrderByTime(String startTime, String endTime);

    // 某段时间内，每日总额
    List<Double> getTotalByTime(String startTime, String endTime);

    // 某商品某段时间内，每日总额
    List<Double> getTotalByItem(String startTime, String endTime, int itemId);

    // 某用户某段时间内，每日总额
    List<Double> getTotalByUser(String startTime, String endTime, int userId);

}
