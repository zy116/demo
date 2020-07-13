package com.boss.demo.dao;

import com.boss.demo.entity.OrderItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
 *
 * 用于将Goods添加到Order中
 * @date 2020/7/13 12:58
 */
@Mapper
@Repository
public interface OrderItem {
    int insertItem(OrderItems orderItems);
}
