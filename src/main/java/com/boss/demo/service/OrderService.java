package com.boss.demo.service;

import com.boss.demo.entity.Order;

public interface OrderService {
    //根据orderid查order页吧
    Order queryOrderByID(int orderId);
}
