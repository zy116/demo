package com.boss.demo.service;

import com.boss.demo.entity.Goods;

import java.util.List;

public interface ServiceDemo {
    //增加一个商品
    int addGoods(Goods goods);

    //根据id删除一个商品
    int deleteGoodsByID(int id);

    //查询所有的商品
    List<Goods> queryAllGoods();
}
