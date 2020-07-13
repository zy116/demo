package com.boss.demo.service;

import com.boss.demo.entity.Goods;

import java.util.HashMap;
import java.util.List;

public interface GoodsService {
    //增加一个商品
    int addGoods(Goods goods);

    //根据id删除一个商品
    int deleteGoodsByID(int id);

    //查询所有的商品，不使用map
    List<Goods> queryAllGoods();
    //查询所有的商品
    String queryAllGoods2();

    HashMap<Integer, Goods> getGoodsMap();
}