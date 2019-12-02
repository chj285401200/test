package com.crcc.service;

import com.crcc.dao.entity.Goods;

/**
 * @author chj
 * @version 1.0
 * @date 2019/12/1 21:16
 */
public interface GoodsService {

    int insertGoods(Goods goods);
    Goods getGoods(Integer id);
}
