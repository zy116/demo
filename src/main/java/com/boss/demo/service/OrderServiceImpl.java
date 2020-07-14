package com.boss.demo.service;

import com.boss.demo.dao.OrderItemMapper;
import com.boss.demo.dao.OrderMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.entity.Order;
import com.boss.demo.entity.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 11:38
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private GoodsServiceImpl goodsService;

    @Override
    public List<Order> selectOrderById(int id) {
        return orderMapper.selectOrder(id);
    }

    @Override
    public List<Order> selectAllOrder() {
        return orderMapper.selectAllOrder();
    }

    @Override
    public void addItems(Order order) {
        HashMap<Integer, Goods> map = goodsService.getGoodsMap();
        //获得key的集合
        Iterator<Integer> mapIt = map.keySet().iterator();
        Goods goodsTmp = null;
        OrderItems orderItemsTmp = null;
        orderMapper.addOrder(order);

        while (mapIt.hasNext()) {
            goodsTmp = map.get(mapIt.next());
            orderItemsTmp = new OrderItems();
            orderItemsTmp.setOrderItemsId(order.getOrderId());
            orderItemsTmp.setGoodsId(goodsTmp.getGoodsId());
            orderItemsTmp.setGoodsName(goodsTmp.getGoodsName());
            orderItemsTmp.setGoodsAddress(goodsTmp.getGoodsAddress());
            orderItemsTmp.setGoodsNum(goodsTmp.getGoodsNum());
            orderItemsTmp.setGoodsTime(goodsTmp.getGoodsTime());
            orderItemsTmp.setGoodsType(goodsTmp.getGoodsType());
            orderItemsTmp.setConId(goodsTmp.getConId());
            orderItemMapper.insertItem(orderItemsTmp);
        }

        map.clear();
    }

}
