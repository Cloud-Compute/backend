package com.hive.sell.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hive.sell.pojo.Item;
import com.hive.sell.pojo.Order;
import com.hive.sell.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderMapper extends BaseMapper<Order> {

//    @Select("SELECT itemId FROM orders GROUP BY itemId")
    List<Item> findTopItem();

    List<User> findTopUser();
}
