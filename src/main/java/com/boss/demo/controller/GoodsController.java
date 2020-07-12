package com.boss.demo.controller;


import com.boss.demo.entity.Goods;
import com.boss.demo.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 10:42
 */
@RestController
public class GoodsController {


    private GoodsServiceImpl goodsService;

    @PostMapping("/add")
    public String add(@RequestBody Goods goods) {
        goodsService.addGoods(goods);
        return "add goods info:" + goods.getGoodsName();
    }

    @PostMapping("/remove")
    public String remove(@RequestBody Goods goods) {
        goodsService.deleteGoodsByID(goods.getGoodsId());
        return null;
    }

    @PostMapping("/list")
    public String list() {
        return goodsService.queryAllGoods();
    }

    @PostMapping("/settle")
    public String settle() {
        return goodsService.settle();
    }
}
