package com.boss.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 11:38
 */

@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private HttpSession session;

    private HashMap<Integer, Goods> goodsMap;
    private Goods goods;

    @Override
    public int addGoods(Goods goods) {
        this.goods = goods;
        getGoodsMap();
        goodsMap.put(goods.getGoodsId(),goods);
        return 1;
    }

    public int deleteGoodsByID(int id) {
        getGoodsMap();
        goodsMap.remove(id);
        return 1;
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }

    public String queryAllGoods2() {
        getGoodsMap();
        return JSONObject.toJSONString(goodsMap.entrySet().toArray());
    }

    public String addItems() {
        orderService.addItems(3);
        return "商品已加入订单";
    }

    public HashMap<Integer, Goods> getGoodsMap() {
        goodsMap= (HashMap) session.getAttribute("goodsMap");
        if (goodsMap == null) {
            goodsMap = new HashMap<Integer, Goods>();
            session.setAttribute("goodsMap", goodsMap);
        }
        return goodsMap;
    }


    /*
     *不使用hashmap
     */

//    @Autowired
//    GoodsMapper goodsMapper;
//
//    @Override
//    public int addGoods(Goods goods) {
//        return goodsMapper.addGoods(goods);
//    }
//
//    @Override
//    public int deleteGoodsByID(int id) {
//        return goodsMapper.deleteGoodsByID(id);
//    }
//
//    @Override
//    public List<Goods> queryAllGoods() {
//        return goodsMapper.queryAllGoods();
//    }

}
