package com.hive.sell.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends DruidHiveRepository {
    public List<Map<String, Object>> getAll() {

        String sql = "SELECT * FROM users";

        List<Map<String, Object>> list = null;
        try {
            list = this.getJdbcTemplate().queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
