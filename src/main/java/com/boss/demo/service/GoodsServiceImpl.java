package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
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

    @Override
    public void addGoods(Goods goods) {
        getGoodsMap();
        goodsMap.put(goods.getGoodsId(),goods);
    }

    public void deleteGoodsByID(int id) {
        getGoodsMap();
        if (goodsMap.containsKey(id)){
            goodsMap.remove(id);
        }
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }

    /*
     * @author 12964
     * @return java.util.HashMap<java.lang.Integer,com.boss.demo.entity.Goods>
     * @date 2020/7/13 16:25
     * 返回的是缓存中的物品
     */
    public HashMap<Integer, Goods> queryAllGoods2() {
        getGoodsMap();
        return goodsMap;
    }

    public String addItems(Order order) {
        orderService.addItems(order);
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
