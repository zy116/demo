package com.boss.demo.controller;

import com.boss.demo.entity.Order;
import com.boss.demo.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


//    {"orderId":"1","orderDep":"设计","orderName":"zouy","orderDate":"2020.8"}
    @GetMapping("/add")
    public String addItem(@RequestBody Order order) {
        if(order==null){
            return "请重新传参";
        }
        else {
            orderService.addInfo(order);
            return "添加进入数据库";
        }

    }

    @RequestMapping("/queryAllOrder")
    public List<Order> selectAllOrder(){
        return orderService.selectAllOrder();
    }
}



