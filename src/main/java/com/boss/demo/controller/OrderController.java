package com.boss.demo.controller;

import com.boss.demo.entity.Order;
import com.boss.demo.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 9:26
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    //    @PostMapping("/add")
//    public String add() {
//        Order order = new Order();
//        order.setUid(3003);
//        order.setSn("2020052800002");
//        orderService.addInfo(order);
//        return "order added " + (new Date()).toString();
//    }
    @GetMapping("/add")
    public void addItem() {
        Order order = new Order();
        order.setOrderID(1);
        order.setOrderName("zyou");
        order.setOrderDep("生产");
        order.setOrderDate("2020.7");
        orderService.addInfo(order);
    }

    @RequestMapping("/queryAllOrder")
    public List<Order> selectAllOrder(){
        return orderService.selectAllOrder();
    }
}


//{"goodsName":"手机","goodsType":"小米","goodsNum":4,"goodsAddress":"福州","goodsTime":"3days""}