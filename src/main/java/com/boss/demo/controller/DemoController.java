package com.boss.demo.controller;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.dao.OrderMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
import com.boss.demo.service.ServiceDemo;
import com.boss.demo.service.ServiceDemoImpl;
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
public class DemoController {

    @Autowired
    ServiceDemo serviceDemo;

    @Autowired
    OrderMapper orderMapper;

    //查询全部的商品，用map返回
    @RequestMapping("/queryAllGoods")
    public Map<Integer,Goods> map(){
        List<Goods> goods = serviceDemo.queryAllGoods();
        Map<Integer,Goods> map = new HashMap<>();
        for (Goods good : goods) {
            map.put(good.getGoodsId(),good);
        }
        return map;
    }

    //根据id删除商品
    @RequestMapping("/deleteGoods/{id}")
    public Boolean delete(@PathVariable("id") int goodsId){
        serviceDemo.deleteGoodsByID(goodsId);
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

    @RequestMapping("/queryOrder/{id}")
    public List<Order> orderList(@PathVariable("id") int id){
        return orderMapper.selectOrder(id);
    }

    @RequestMapping("/queryAllOrder")
    public List<Order> selectAllOrder(){
        return orderMapper.selectAllOrder();
    }
}
