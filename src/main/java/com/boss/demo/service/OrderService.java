package com.boss.demo.service;

import com.boss.demo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    List<Order> selectOrder(@Param("oid") int id);
    List<Order> selectAllOrder();
}
