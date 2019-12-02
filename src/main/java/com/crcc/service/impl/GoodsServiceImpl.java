package com.crcc.service.impl;

import com.crcc.dao.entity.Goods;
import com.crcc.dao.mapper.GoodsMapper;
import com.crcc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chj
 * @version 1.0
 * @date 2019/12/1 21:17
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int insertGoods(Goods goods) {
       return goodsMapper.insert(goods);
    }

    @Override
    public Goods getGoods(Integer id) {
        System.out.println(1);
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        System.out.println(2);
        return goods;
    }
}
