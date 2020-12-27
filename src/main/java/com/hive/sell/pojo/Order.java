package com.hive.sell.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("orders")
@ToString(callSuper = true)
public class Order {

    @TableId(value = "id")
    private String id;

    @TableField(value = "userId")
    private String userId;

    @TableField(value = "itemId")
    private String itemId;

    @TableField(value = "count")
    private String count;

    @TableField(value = "payment")
    private String payment;

    @TableField("orderTime")
    private String orderTime;
}
