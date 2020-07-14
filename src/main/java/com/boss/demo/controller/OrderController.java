package com.boss.demo.controller;

import com.boss.demo.entity.Order;
import com.boss.demo.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /*
     *将订单加入数据库操作
     * 格式：{"orderId":"1","orderDep":"设计","orderName":"zouy","orderDate":"2020.8"}
     * @param order
     * @author 12964
     * @return java.lang.String
     * @date 2020/7/14 11:04
     */
    @RequestMapping("/add")
    public String addItem(@RequestBody Order order) {
        orderService.addItems(order);
        return "订单提交";

    }

    /*
     * 查询数据库中的所有订单
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Order>
     * @date 2020/7/14 11:04
     */
    @RequestMapping("/queryAllOrder")
    public List<Order> selectAllOrder() {
        return orderService.selectAllOrder();
    }

    /*
     * 根据id查询数据库中的所有订单
     * @param id
     * @author 12964
     * @return java.util.List<com.boss.demo.entity.Order>
     * @date 2020/7/14 14:50
     */
    @RequestMapping("/queryAllOrder/{id}")
    public List<Order> selectOrderById(@PathVariable("id") int id) {
        return orderService.selectOrderById(id);
    }
}



