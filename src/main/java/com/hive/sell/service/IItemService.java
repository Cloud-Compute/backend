package com.hive.sell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hive.sell.pojo.Item;

import java.util.List;

public interface IItemService extends IService<Item> {

    List<Item> getAll();

//    Item getOneById(int id);
}
