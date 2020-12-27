package com.hive.sell.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DruidHiveRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {return jdbcTemplate;}

    @Autowired
    public void setJdbcTemplate(@Qualifier("hiveDruidDataSource")DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
