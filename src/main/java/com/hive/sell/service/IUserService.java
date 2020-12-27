package com.hive.sell.service;

import com.hive.sell.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    String getIdByName(String name);

    List<User>  getAll();
}
