package com.boss.demo.service;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.dao.OrderItem;
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

    /*
    * 不使用hashmap的情况
    * */
//
//    @Autowired
//    private OrderMapper orderMapper;

    @Override
    public List<Order> selectOrder(int id) {
        return orderMapper.selectOrder(id);
    }

    @Override
    public List<Order> selectAllOrder() {
        return orderMapper.selectAllOrder();
    }
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItem orderItem;
    @Autowired
    private GoodsService goodsService;

    public void addInfo(Order order){
        orderMapper.addOrder(order);
    }

    public void addItems(int Id) {
        Order order = new Order();
        HashMap<Integer, Goods> map = goodsService.getGoodsMap();
        //获得key的集合
        Iterator mapIt = map.keySet().iterator();
        Goods goodsTmp = null;
        OrderItems orderItemsTmp = null;

        order.setOrderID(Id);
        order.setOrderDate("2020.07");
        order.setOrderDep("设计");
        order.setOrderName("zouy");
        orderMapper.addOrder(order);

        while (mapIt.hasNext()) {
            goodsTmp = map.get(mapIt.next());
            orderItemsTmp = new OrderItems();
            orderItemsTmp.setOrderItemsId(order.getOrderID());
            orderItemsTmp.setGoodsId(goodsTmp.getGoodsId());
            orderItemsTmp.setGoodsName(goodsTmp.getGoodsName());
            orderItemsTmp.setGoodsAddress(goodsTmp.getGoodsAddress());
            orderItemsTmp.setGoodsNum(goodsTmp.getGoodsNum());
            orderItemsTmp.setGoodsTime(goodsTmp.getGoodsTime());
            orderItemsTmp.setGoodsType(goodsTmp.getGoodsType());
            orderItem.insertItem(orderItemsTmp);
        }
    }

}
