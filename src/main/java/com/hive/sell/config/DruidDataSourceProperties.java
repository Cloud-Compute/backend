package com.hive.sell.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {
    final static String DS = "spring.datasource.druid";

    private String username;

    private String password;

    private String url;

    private String driverClassName;

    private Integer initialSize;

    private Integer maxActive;

    private Integer minIdle;

    private long maxWait;

    private boolean poolPreparedStatements;

    public String filters;

    // lombok get & set

}
