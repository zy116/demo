package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/13 8:34
 */
@Service
public class ServiceDemoImpl implements ServiceDemo {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoodsByID(int id) {
        return goodsMapper.deleteGoodsByID(id);
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }
}
