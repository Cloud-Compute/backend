package com.hive.sell.controller;

import com.hive.sell.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("all")
    public String getAllUser() {
        return userDao.getAll();
    }
}
