package com.boss.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 9:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int orderId;

    private String orderDep;

    private String orderName;

    private String orderDate;

    private List<Goods> itemGoods;
}
