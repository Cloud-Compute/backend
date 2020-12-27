package com.hive.sell.repository;

import com.hive.sell.POJO.User;
import com.hive.sell.repository.DruidHiveRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * users
 * id phone name
 */
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

    public String getIdByName(String name) {

        String sql = "SELECT * FROM users WHERE id=?";

//        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);
        User user = this.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name);
        return user.getId();
    }
}
