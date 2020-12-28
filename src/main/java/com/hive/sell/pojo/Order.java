package com.hive.sell.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@TableName("orders")
@ToString(callSuper = true)
public class Order {

    @TableId(value = "id")
    private int id;

    @TableField(value = "userId")
    private int userId;

    @TableField(value = "itemId")
    private int itemId;

    @TableField(value = "count")
    private int count;

    @TableField(value = "payment")
    private double payment;

    @TableField("orderTime")
    private String orderTime;

    // 订单时间 标准格式
    @TableField(exist = false)
    private Date time;

    /* 销售总额 */
    @TableField(exist = false)
    private double total;
}
