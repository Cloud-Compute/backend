package com.hive.sell.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("items")
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @TableId
    private int id;

    private String name;

    private String description;

    private double price;

    @TableField(exist = false)
    private double total;
}
