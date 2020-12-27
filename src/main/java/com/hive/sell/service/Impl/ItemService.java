package com.hive.sell.service.Impl;

import com.hive.sell.dao.ItemMapper;
import com.hive.sell.pojo.Item;
import com.hive.sell.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getAll() {
        return itemMapper.selectList(null);
    }
}
