package com.boss.demo.dao;


import com.boss.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    //根据orderid查order页吧
    Order queryOrderByID(int orderId);
}
