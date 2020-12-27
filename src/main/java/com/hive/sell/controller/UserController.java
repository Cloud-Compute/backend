package com.hive.sell.controller;

import com.hive.sell.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/api/getAllUser")
    public List<Map<String, Object>> getAllUser() {
        return userDao.getAll();
    }

    @GetMapping("/test/id")
    public String getId(@RequestParam() String name) {
        return userDao.getIdByName(name);
    }
}
