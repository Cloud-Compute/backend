package com.hive.sell.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hive.sell.dao.OrderMapper;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.pojo.User;
import com.hive.sell.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

//    private List<Order> orders = getAll();

    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }

    public List<Order> getOrderByItemId(int itemId) {
        QueryWrapper<Order> query = new QueryWrapper<>();
        query.eq("itemId", itemId);
        return orderMapper.selectList(query);
    }


    // 得到每种产品的总销量
    // Map<Integer, Double>
    public List<Number> getTopItem() {
//        QueryWrapper<Order> query = new QueryWrapper<>();
//        query.select("sum(payment) as total, itemID")
//                .groupBy("ItemID")
//                .orderByDesc("total");
//        List<Map<String, Object>> orders = orderMapper.selectMaps(query);
//        System.out.println(orders);

//        List<Item> items = orderMapper.findTopItem();
//        return items;

        List<Order> orders = this.getAll();
        /* itemId, sum(payment) */
        Map<Integer, Double> itemSell = orders.stream().collect(
                Collectors.groupingBy(Order::getItemId, Collectors.summingDouble(Order::getPayment)));

//        return sortTotal(itemSell);
//        return itemSell;
//        return this.findMaxValue(itemSell);
        return this.getMax(itemSell);
    }

    public List<Number> getTopUser() {
        List<Order> orders = this.getAll();
        Map<Integer, Double> userSell = orders.stream().collect(
                Collectors.groupingBy(Order::getUserId, Collectors.summingDouble(Order::getPayment)));
        return this.getMax(userSell);
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

    // sort map by value, desc
    private Map<Integer, Double> sortTotal(Map<Integer, Double> groupMap) {

        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(groupMap.entrySet());
        entryList.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        Map<Integer, Double> resultMap = new HashMap<>();
        for ( Map.Entry<Integer, Double> entry : entryList) {
            resultMap.put(entry.getKey(), entry.getValue());
        }

        return resultMap;
    }


    private Map<Integer, Double> findMaxValue(Map<Integer, Double> groupMap) {
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(groupMap.entrySet());
        Map.Entry<Integer, Double> max =  entryList.stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get();
        HashMap<Integer, Double> result = new HashMap<>();
        result.put(max.getKey(), max.getValue());
        return result;
    }

    ////只要找最大值，再找该值对应所有key，返回List(key, id1, id2...)
    private List<Number> getMax(Map<Integer, Double> groupMap) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(0.0);
        for (Map.Entry<Integer, Double> entry : groupMap.entrySet()) {
            if (entry.getValue() > (Double)list.get(0)) {
                list.clear();
                list.add(entry.getValue());
                list.add(entry.getKey());
            }
            else if (entry.getValue().equals(list.get(0))) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
