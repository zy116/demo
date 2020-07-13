package com.boss.demo.controller;


import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
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

    GoodsServiceImpl goodsService;

    @GetMapping("/add")
    public String add(@PathVariable Goods goods) {
        goodsService.addGoods(goods);
        return "add goods info:" + goods.getGoodsName();
    }

    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        goodsService.deleteGoodsByID(goods.getGoodsId());
        return "delete goods info:" + goods.getGoodsName();
    }

    @PostMapping("/list")
    public String list() {
        return goodsService.queryAllGoods();
    }

    @PostMapping("/addItems")
    public String addItems() {
        return goodsService.addItems();
    }
}
