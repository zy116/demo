package com.boss.demo.controller;

import com.boss.demo.dao.GoodsMapper;
import com.boss.demo.entity.Goods;
import com.boss.demo.service.ServiceDemo;
import com.boss.demo.service.ServiceDemoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/13 8:38
 */

@RestController
public class DemoController {

    @Autowired
    ServiceDemo serviceDemo;

    @RequestMapping("/queryAllGoods")
    public Map<Integer,Goods> list(){
        List<Goods> goods = serviceDemo.queryAllGoods();
        Map<Integer,Goods> map = new HashMap<>();
        for (Goods good : goods) {
            map.put(good.getGoodsId(),good);
        }
        return map;
    }
}
