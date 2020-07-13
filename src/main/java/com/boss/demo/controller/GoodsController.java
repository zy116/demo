package com.boss.demo.controller;


import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
import com.boss.demo.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 10:42
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

//    @Autowired
//    GoodsMapper goodsMapper;


    @Autowired
    GoodsServiceImpl goodsService;

 
    /*
     *添加物品进入缓存，传入参数格式为 
     * {"goodsId":4,"goodsName":"手机","goodsType":"苹果",
     * "goodsNum":6,  "goodsAddress":"福州","goodsTime":"2days","conId":"2"}
     * @param goods
     * @author 12964
     * @return java.lang.String
     * @date 2020/7/13 16:38
     */
    @RequestMapping("/add")
    public String add(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return "添加进缓存的物品是:" + goods.getGoodsName();
    }

    /*
     * 根据goodsId删除缓存中的物品
     * @param id
     * @author 12964
     * @return java.lang.String
     * @date 2020/7/13 16:39
     */    
    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id) {
        goodsService.deleteGoodsByID(id);
        return "删除了id为"+id+"的物品";
    }

    /*
     * 查看缓存中的物品
     * @author 12964
     * @return java.util.HashMap<java.lang.Integer,com.boss.demo.entity.Goods>
     * @date 2020/7/13 16:40
     */
    @RequestMapping("/list")
    public HashMap<Integer, Goods> list() {
        return goodsService.queryAllGoods2();
    }

    /*
     * @param order
     * @author 12964
     * @return java.lang.String
     * @date 2020/7/13 16:40
     */
//    {"orderId":"1","orderDep":"设计","orderName":"zouy","orderDate":"2020.8"}
    @RequestMapping("/addItems")
    public String addItems(@RequestBody Order order) {
        goodsService.addItems(order);
        return "加入完毕";
    }

    //查询数据库中全部商品
    @RequestMapping("/queryAllGoods")
    public List<Goods> selectAllGoods(){
        return goodsService.queryAllGoods();
    }
}
