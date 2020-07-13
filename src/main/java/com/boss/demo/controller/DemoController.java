package com.boss.demo.controller;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.dao.OrderMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
import com.boss.demo.service.GoodsService;
import com.boss.demo.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/13 8:38
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;


    /*
    * 不使用hashmap
    * */


//    //查询全部的商品，用map返回
//    @RequestMapping("/queryAllGoods")
//    public Map<Integer,Goods> map(){
//        List<Goods> goods = serviceDemo.queryAllGoods();
//        Map<Integer,Goods> map = new HashMap<>();
//        for (Goods good : goods) {
//            map.put(good.getGoodsId(),good);
//        }
//        return map;
//    }

    //查询全部商品
    @RequestMapping("/queryAllGoods")
    public List<Goods> selectAllGoods(){
        return goodsService.queryAllGoods();
    }

    //根据id删除商品
    @RequestMapping("/deleteGoods/{id}")
    public Boolean delete(@PathVariable("id") int goodsId){
        goodsService.deleteGoodsByID(goodsId);
        return true;
    }

//    @RequestMapping("/queryOrder/{id}")
//    public Map<Integer, Order> orderMap(@PathVariable("id") int id){
//        List<Order> goods = orderMapper.selectOrder(id);
//        Map<Integer,Order> map = new HashMap<>();
//        for (Order order : goods) {
//            map.put(order.getOrderID(),order);
//        }
//        return map;
//    }
//
    //根据订单的id查询订单
//    @RequestMapping("/queryOrder/{id}")
//    public List<Order> orderList(@PathVariable("id") int id){
//        return orderService.selectOrder(id);
//    }

    //查询全部订单
    @RequestMapping("/queryAllOrder")
    public List<Order> selectAllOrder(){
        return orderService.selectAllOrder();
    }
}
