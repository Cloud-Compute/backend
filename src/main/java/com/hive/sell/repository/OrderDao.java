package com.hive.sell.repository;

import com.hive.sell.repository.DruidHiveRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * orders
 * ID,UserID,ItemID,Count,Payment,OrderTime
 */
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
