package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private HttpSession session;

    /*
     * hashmap变量，用于充当购物车功能
     * @param null
     * @author 12964
     * @return
     * @date 2020/7/14 15:38
     */
    private HashMap<Integer, Goods> goodsMap;

    /*
     * 添加物品到缓存中
     * @param goods
     * @author 12964
     * @return void
     * @date 2020/7/14 15:37
     */
    @Override
    public void addGoods(Goods goods) {
        getGoodsMap();
        goodsMap.put(goods.getGoodsId(),goods);
    }

    /*
     * 查询缓存中的所有物品
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Goods>
     * @date 2020/7/14 15:38
     */
    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }


    /*
     * 根据id删除缓存中的物品
     * @param id
     * @author 12964
     * @return void
     * @date 2020/7/14 15:39
     */
    @Override
    public void deleteGoodsByID(int id) {
        getGoodsMap();
        if (goodsMap.containsKey(id)){
            goodsMap.remove(id);
        }
    }

    /*
     * 查询数据库中的所有商品
     * @author 12964
     * @return java.util.HashMap<java.lang.Integer,com.boss.demo.entity.Goods>
     * @date 2020/7/14 15:39
     */
    public HashMap<Integer, Goods> queryAllGoods2() {
        getGoodsMap();
        return goodsMap;
    }


    /*
     * 用于得到缓存中的hashmap，如果没有则新建一个hashmap对象
     * @author 12964
     * @return java.util.HashMap<java.lang.Integer,com.boss.demo.entity.Goods>
     * @date 2020/7/14 15:40
     */
    public HashMap<Integer, Goods> getGoodsMap() {
        goodsMap= (HashMap) session.getAttribute("goodsMap");
        if (goodsMap == null) {
            goodsMap = new HashMap<>();
            session.setAttribute("goodsMap", goodsMap);
        }
        return goodsMap;
    }
}
