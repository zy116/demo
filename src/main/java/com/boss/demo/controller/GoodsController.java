package com.boss.demo.controller;


import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 10:42
 */
@RestController
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    // 增加一个商品
    @GetMapping("/getGoods")
    public List<Goods> queryAllGoods(){
        return goodsMapper.queryAllGoods();
    }

    // 查询全部商品
    @GetMapping("/deleteGoods")
    public Boolean deleteGoodsByID(@PathVariable int id){
        return true;
    }


}
