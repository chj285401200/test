package com.crcc.controller;

import com.crcc.dao.entity.Goods;
import com.crcc.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping ("/goods")
    public Integer addGoods(@RequestBody Goods goods){
       return   goodsService.insertGoods(goods);
    }
    @GetMapping("/goods")
    public Goods getGoods(@RequestParam Integer id){
        return goodsService.getGoods(id);
    }


}
