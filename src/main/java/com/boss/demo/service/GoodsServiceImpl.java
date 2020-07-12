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
public class GoodsServiceImpl{

    private OrderServiceImpl orderService;
    @Autowired
    private HttpSession session;

    private HashMap<Integer, Goods> goodsMap;
//    private GoodsMapper goodsMapper;
//
//    public void setGoodsMapper(GoodsMapper goodsMapper) {
//        this.goodsMapper = goodsMapper;
//    }

    public Boolean addGoods(Goods goods) {
        getGoodsMap();
        goodsMap.put(goods.getGoodsId(),goods);
        return true;
    }

    public Boolean deleteGoodsByID(int id) {
        getGoodsMap();
        goodsMap.remove(id);
        return true;
    }

    public String queryAllGoods() {
        getGoodsMap();
        return goodsMap.entrySet().toArray().toString();
    }

    public String addGoods() {
        orderService.addGoods(122);
        return "Cart Service Settled";
    }


    public HashMap<Integer, Goods> getGoodsMap() {
        goodsMap= (HashMap) session.getAttribute("goodsMap");
        if (goodsMap == null) {
            goodsMap = new HashMap<Integer, Goods>();
            session.setAttribute("goodsMap", goodsMap);
        }
        return goodsMap;
    }



}
