package com.hive.sell.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hive.sell.dao.UserMapper;
import com.hive.sell.pojo.User;
import com.hive.sell.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public String getIdByName(String name) {
        return "1";
    }

    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
