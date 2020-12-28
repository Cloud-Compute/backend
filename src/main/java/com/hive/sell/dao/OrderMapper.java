package com.hive.sell.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {

//    @Select("SELECT itemId FROM orders GROUP BY itemId")
    List<Item> findTopItem();
}
