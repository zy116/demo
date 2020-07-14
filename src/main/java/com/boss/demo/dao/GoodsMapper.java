package com.boss.demo.dao;


import com.boss.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface GoodsMapper {
    //增加一个商品
    int addGoods(Goods goods);

    //根据id删除一个商品
    int deleteGoodsByID(int id);

    //查询数据库的所有商品
    List<Goods> queryAllGoods();

}
