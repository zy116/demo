package com.boss.demo.service;

import com.boss.demo.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


public interface GoodsService {
    //增加一个商品
    void addGoods(Goods goods);

    //根据id删除一个商品
    void deleteGoodsByID(int id);

    //查询所有的商品
    List<Goods> queryAllGoods();
}
