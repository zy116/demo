package com.boss.demo.dao;


import com.boss.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> selectOrder(@Param("oid") int id);
    List<Order> selectAllOrder();
}
