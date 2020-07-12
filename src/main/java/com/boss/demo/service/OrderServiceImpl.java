package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.dao.OrderMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
import com.boss.demo.entity.OrderItems;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 11:38
 */
public class OrderServiceImpl {
    private GoodsMapper goodsMapper;

    private OrderMapper orderMapper;

    private GoodsServiceImpl goodsService;

    public void addInfo(OrderItems orderItems){
        orderMapper.addInfo(orderItems);
    }

    public void addGoods(int Id) {
        Order order = new Order();
        HashMap<Integer, Goods> map = goodsService.getGoodsMap();
        Iterator mapIt = map.keySet().iterator();
        Goods goodsTmp = null;
        OrderItems orderItemsTmp = null;


        while (mapIt.hasNext()) {
            goodsTmp = (Goods)mapIt.next();
            orderItemsTmp = new OrderItems();
            orderItemsTmp.setOrderItemsId(order.getOrderID());
            orderItemsTmp.setGoodsId(goodsTmp.getGoodsId());
            orderItemsTmp.setGoodsName(goodsTmp.getGoodsName());
            orderItemsTmp.setGoodsAddress(goodsTmp.getGoodsAddress());
            orderItemsTmp.setGoodsNum(goodsTmp.getGoodsNum());
            orderItemsTmp.setGoodsTime(goodsTmp.getGoodsTime());
            orderItemsTmp.setGoodsType(goodsTmp.getGoodsType());
            orderMapper.addInfo(orderItemsTmp);
        }
    }
}
