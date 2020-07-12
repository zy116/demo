package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 11:38
 */
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private HttpSession session;

    private HashMap<Integer, Goods> goods;
    private GoodsMapper goodsMapper;

    public void setGoodsMapper(GoodsMapper goodsMapper) {
        getGoodsMap();
        this.goodsMapper = goodsMapper;
    }

    @Override
    public int addGoods(Goods goods) {
        getGoodsMap();
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoodsByID(int id) {
        getGoodsMap();
        return goodsMapper.deleteGoodsByID(id);
    }

    @Override
    public List<Goods> queryAllGoods() {
        getGoodsMap();
        return goodsMapper.queryAllGoods();
    }

    public HashMap<Integer, Goods> getGoodsMap() {
        goods = (HashMap) session.getAttribute("goodsMap");
        if (goods == null) {
            goods = new HashMap<Integer, Goods>();
            session.setAttribute("goodsMap", goods);
        }
        return goods;
    }



}
