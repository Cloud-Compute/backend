package com.hive.sell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hive.sell.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserService extends IService<User> {

    String getIdByName(String name);

    List<User>  getAll();
}
