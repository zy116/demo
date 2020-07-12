package com.boss.demo.service;

import com.boss.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 12964
 * @version 1.0
 * @date 2020/7/12 11:38
 */
public class GoodsService {
    @Autowired
    private HttpSession session;

    @Autowired
    private OrderService orderService;

    private HashMap<Long, Goods> goodsMap;

    public boolean add(Goods goods) {
        getCart();
        goodsMap.put(goods.getId(), goods);
        return true;
    }

    public boolean remove(long goodsId) {
        getCart();
        goodsMap.remove(goodsId);
        return true;
    }

    public boolean edit(long goodsId, int number) {
        getCart();
        Goods goods = goodsMap.get(goodsId);
        goods.setNumber(number);
        return true;
    }

    public String list() {
        getCart();
        return goodsMap.entrySet().toArray().toString();
    }

    public String settle() {
        orderService.settleCart(getOwnerId());
        return "Cart Service Settled";
    }

    public long getOwnerId() {
        return 3003; //此处假使一个已存在用户ID
    }

    public HashMap<Long, Goods> getCart() {
        goodsMap = (HashMap) session.getAttribute("goodsMap");
        if (goodsMap == null) {
            goodsMap = new HashMap<Long, Goods>();
            session.setAttribute("goodsMap", goodsMap);
        }
        return goodsMap;
    }
}
