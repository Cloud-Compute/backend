package com.hive.sell.controller;

import com.hive.sell.GlobalResult.DataResult;
import com.hive.sell.pojo.User;
import com.hive.sell.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("api/getAllUser")
    public DataResult getAll() {

        return DataResult.build(iUserService.getAll());
    }

//    @RequestMapping("api/getAllOrdersOfUser")
//    public

}
