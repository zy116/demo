package com.boss.demo.controller;

import com.boss.demo.entity.Order;
import com.boss.demo.entity.OrderItems;
import com.boss.demo.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 9:26
 */

@RestController
@RequestMapping("/order")
public class OrderController {

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
        OrderItems orderItems = new OrderItems();
        orderService.addItems(11);
    }
}
