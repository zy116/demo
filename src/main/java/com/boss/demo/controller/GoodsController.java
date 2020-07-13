package com.boss.demo.controller;


import com.boss.demo.entity.Goods;
import com.boss.demo.service.GoodsService;
import com.boss.demo.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/add")
    public String add(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return "add goods info:" + goods.getGoodsName();
    }

    @RequestMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        goodsService.deleteGoodsByID(goods.getGoodsId());
        return "delete goods info:" + goods.getGoodsName();
    }

    @RequestMapping("/list")
    public String list() {
        return goodsService.queryAllGoods2();
    }

    @RequestMapping("/addItems")
    public String addItems() {
        goodsService.addItems();
        return "加入完毕";
    }

//    //查询全部商品
//    @RequestMapping("/queryAllGoods")
//    public List<Goods> selectAllGoods(){
//        return goodsService.queryAllGoods();
//    }
}
