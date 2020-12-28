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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;


    public List<Order> getAll() {
        return orderMapper.selectList(null);
    }

    // 某商品所有订单
    private List<Order> getOrderByItemId(int itemId) {
        QueryWrapper<Order> query = new QueryWrapper<>();
        query.eq("itemId", itemId);
        return orderMapper.selectList(query);
    }

    // 某用户所有订单
    private List<Order> getOrderByUserId(int userId) {
        QueryWrapper<Order> query = new QueryWrapper<>();
        query.eq("userId", userId);
        return orderMapper.selectList(query);
    }

    // 产品总销量的最大值及对应itemIDs
    public List<Number> getTopItem() {

        List<Order> orders = this.getAll();
        /* itemId, sum(payment) */
        Map<Integer, Double> itemSell = orders.stream().collect(
                Collectors.groupingBy(Order::getItemId, Collectors.summingDouble(Order::getPayment)));
        return this.getMax(itemSell);
    }

    // 用户总购买额的最大值及对应userIDs
    public List<Number> getTopUser() {
        List<Order> orders = this.getAll();
        Map<Integer, Double> userSell = orders.stream().collect(
                Collectors.groupingBy(Order::getUserId, Collectors.summingDouble(Order::getPayment)));
        return this.getMax(userSell);
    }


    // 字符串转Date 到秒
    private Date getDateByString(String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return sdf.parse(day);
        } catch (ParseException e) {
            System.out.println("Time String Error");
            e.printStackTrace();
        }
        return null;
    }

    // 字符串转Date 到日
    private Date getDate(Date day) {
        SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
        String str = formatter.format(day);
        try {
            return formatter.parse(str);
        } catch (ParseException e) {
            System.out.println("Time String Error");
            e.printStackTrace();
        }
        return null;
    }


    // 一段时间内所有订单
    public List<Order> getOrderByTime(String startTime, String endTime) {
        Date start = this.getDateByString(startTime);
        Date end = this.getDateByString(endTime);
        return this.getOrderByTime(start, end, this.getAll());
    }

    // 筛选一段时间内的订单
    private List<Order> getOrderByTime(Date start, Date end, List<Order> orders) {
        List<Order> result = new LinkedList<>();
        for (Order order : orders) {
            Date time = this.getDateByString(order.getOrderTime());
            if (time.after(start) && time.before(end)) {
                order.setTime(this.getDate(time));
                result.add(order);
            }
        }
        return result;
    }

    // 处理订单列表为返回值（每日总额）
    private List<Double> getTotalPerDay(List<Order> orders, Date start, Date end) {
        // 合计
        Map<Date, Double> totalPerDay = orders.stream().collect(
                Collectors.groupingBy(Order::getTime, Collectors.summingDouble(Order::getPayment)));

        // 补全
        Calendar calendar = new GregorianCalendar();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        for (Date d = start; d.before(end); ) {
            if (!totalPerDay.containsKey(d)) totalPerDay.put(d, 0.0);
            // next date
            calendar.setTime(d);
            calendar.add(Calendar.DATE,1);
            d=calendar.getTime();
        }

        // 排序
        Map<Date, Double> sortMap = new TreeMap<>(Date::compareTo);
        sortMap.putAll(totalPerDay);

        return new ArrayList<>(sortMap.values());
    }

    // 某段时间内所有订单，每日总额
    public List<Double> getTotalByTime(String startTime, String endTime) {
        Date start = this.getDateByString(startTime);
        Date end = this.getDateByString(endTime);

        // 某时间段内订单list
        List<Order> orders = this.getOrderByTime(start, end, this.getAll());

        return this.getTotalPerDay(orders, start, end);
    }

    // 某商品某段时间内，每日总额
    public List<Double> getTotalByItem(String startTime, String endTime, int itemId) {
        Date start = this.getDateByString(startTime);
        Date end = this.getDateByString(endTime);

        // 某时间段内订单list
        List<Order> orders = this.getOrderByTime(start, end, this.getOrderByItemId(itemId));

        return this.getTotalPerDay(orders, start, end);
    }

    // 一段时间内,Orders按User分组
    public List<Double> getTotalByUser(String startTime, String endTime, int userId) {
        Date start = this.getDateByString(startTime);
        Date end = this.getDateByString(endTime);

        // 某时间段内订单list
        List<Order> orders = this.getOrderByTime(start, end, this.getOrderByUserId(userId));

        return this.getTotalPerDay(orders, start, end);
    }

    //找到Map中的最大value，和对应的keys
    //只要找最大值，再找该值对应所有key，返回List(key, id1, id2...)
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

    // sort map by value, desc
//    private Map<Integer, Double> sortTotal(Map<Integer, Double> groupMap) {
//
//        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(groupMap.entrySet());
//        entryList.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
//
//        Map<Integer, Double> resultMap = new HashMap<>();
//        for ( Map.Entry<Integer, Double> entry : entryList) {
//            resultMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return resultMap;
//    }


//    private Map<Integer, Double> findMaxValue(Map<Integer, Double> groupMap) {
//        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(groupMap.entrySet());
//        Map.Entry<Integer, Double> max =  entryList.stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).get();
//        HashMap<Integer, Double> result = new HashMap<>();
//        result.put(max.getKey(), max.getValue());
//        return result;
//    }

}
