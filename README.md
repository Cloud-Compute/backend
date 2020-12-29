## 使用方法

请在 `src/main/resources/` 下新建文件 `application.yml`，并按如下格式填写内容：

```yml
server:
  port: [Spring Boot监听端口]

spring:
  datasource:
      # hive数据源
      url: jdbc:hive2://[服务器IP]:[服务器端口]/[URL]
      username: [用户名]
      password: [密码]
      driver-class-name: org.apache.hive.jdbc.HiveDriver
      type: com.alibaba.druid.pool.DruidDataSource

mybatis-plus:
  mapper-locations: classpath*:/mapper/**Mapper.xml
  type-aliases-package: com.hive.sell.pojo
```
