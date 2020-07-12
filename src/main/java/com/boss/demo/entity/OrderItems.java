package com.boss.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/10 14:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    private int OrderItemsId;
    private int goodsId;
    private String goodsName;
    private String goodsType;
    private int goodsNum;
    private String goodsAddress;
    private String goodsTime;
}
