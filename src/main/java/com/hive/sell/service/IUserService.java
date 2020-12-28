package com.hive.sell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hive.sell.pojo.User;

import java.util.List;

public interface IUserService extends IService<User> {

    List<User>  getAll();
}
