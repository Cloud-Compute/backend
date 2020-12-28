package com.hive.sell.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hive.sell.pojo.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

}
