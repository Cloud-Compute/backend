package com.hive.sell.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hive.sell.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

}
