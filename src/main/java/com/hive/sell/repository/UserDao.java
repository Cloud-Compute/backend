package com.hive.sell.repository;

import com.hive.sell.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends DruidHiveRepository {
    public String getAll() {
//        String sql = "SELECT * FROM users";

//        List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);
//        System.out.println(list);
        return "ok";
    }
}
