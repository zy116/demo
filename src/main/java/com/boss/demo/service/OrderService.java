package com.boss.demo.service;

import com.boss.demo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderService {
    List<Order> selectOrderById(@Param("oid") int id);
    List<Order> selectAllOrder();
    void  addItems(Order order);
}
