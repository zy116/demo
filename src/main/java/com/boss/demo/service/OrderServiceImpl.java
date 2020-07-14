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


    /*
     * 根据id查询数据库中的所有订单
     * @param id
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Order>
     * @date 2020/7/14 15:42
     */
    @Override
    public List<Order> selectOrderById(int id) {
        return orderMapper.selectOrder(id);
    }


    /*
     * 查询数据库中所有订单
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Order>
     * @date 2020/7/14 15:42
     */
    @Override
    public List<Order> selectAllOrder() {
        return orderMapper.selectAllOrder();
    }


    /*
     * 将缓存中的物品加入订单并进入数据库
     * @param order
     * @author 12964
     * @return void
     * @date 2020/7/14 15:41
     */
    @Override
    public void addItems(Order order) {
        HashMap<Integer, Goods> map = goodsService.getGoodsMap();
        //获得map的所有key
        Iterator<Integer> mapIt = map.keySet().iterator();
        Goods goodsTmp = null;
        OrderItems orderItemsTmp = null;

        //将订单信息添加进数据库
        orderMapper.addOrder(order);


        //遍历map，将物品全部加入数据库
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
