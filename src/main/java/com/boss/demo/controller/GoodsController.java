package com.boss.demo.controller;


import com.boss.demo.entity.Goods;
import com.boss.demo.service.GoodsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 10:42
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {


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
    @ApiOperation("添加物品进入缓存的方法")
    @RequestMapping("/add")
    public String add(@RequestBody@ApiParam("传入物品对象") Goods goods) {
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
    @ApiOperation("根据id删除缓存物品的方法")
    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id")@ApiParam("传入id") int id) {
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
    public Map<Integer, Goods> list() {
        return goodsService.queryAllGoods2();
    }

    /*
     * 查询数据库中的所有物品
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Goods>
     * @date 2020/7/14 14:47
     */
    @RequestMapping("/queryAllGoods")
    public List<Goods> selectAllGoods(){
        return goodsService.queryAllGoods();
    }
}
