package com.hive.sell.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;


@Configuration
@EnableConfigurationProperties(value = DruidDataSourceProperties.class)
public class DruidDataSourceConfig {

//    private static Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Autowired
    private DruidDataSourceProperties druidDataSourceProperties;

    @Bean
    @Qualifier("hiveDruidDataSource") //标识
    public DruidDataSource dataSource() {

        DruidDataSource druidDataSource = new DruidDataSource();
        // 配置数据源
        druidDataSource.setUrl(druidDataSourceProperties.getUrl());
        druidDataSource.setUsername(druidDataSourceProperties.getUsername());
        druidDataSource.setPassword(druidDataSourceProperties.getPassword());
        druidDataSource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
        // 配置连接池
        druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
        druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
        druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
        druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
        druidDataSource.setPoolPreparedStatements(druidDataSourceProperties.isPoolPreparedStatements());
        try {
            druidDataSource.setFilters(druidDataSourceProperties.getFilters());
        } catch (SQLException e) {
//            logger.error("Druid configuration initialization filter error.", e);
            e.printStackTrace();
        }
        return druidDataSource;
    }

    /*
     * 配置druid管理后台的servlet
     */
//    @Bean
//    public ServletRegistrationBean statViewSerlvet() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String, Object> initParameters = new HashMap<>();
//        initParameters.put("loginUsername", "admin");
//        initParameters.put("loginPassword", "123456");
//        bean.setInitParameters(initParameters);
//        return bean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//
//        Map<String, Object> initParams = new HashMap<>();
//        initParams.put("exclusions", "*.js,*.css,/druid/*");
//        filterRegistrationBean.setInitParameters(initParams);
//        return filterRegistrationBean;
//    }
}
