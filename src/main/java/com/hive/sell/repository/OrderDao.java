package com.hive.sell.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderDao extends DruidHiveRepository {

    public List<Map<String, Object>> getAll() {

        String sql = "SELECT * FROM orders";

        List<Map<String, Object>> list = null;
        try {
            list = this.getJdbcTemplate().queryForList(sql);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
