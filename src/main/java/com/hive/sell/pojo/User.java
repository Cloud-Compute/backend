package com.hive.sell.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("users")
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String name;

    private String phone;
}
