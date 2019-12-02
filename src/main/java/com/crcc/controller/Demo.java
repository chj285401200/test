package com.crcc.controller;

import com.crcc.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class Demo {

    @RequestMapping("/demo")
    public String demo(){
        return "this is a demo";
    }

    @RequestMapping("/int")
    public String testGet(@RequestParam List<Integer> ids){
        System.out.println(ids);
        return "this is a demo";
    }
    @RequestMapping("/multiint")
    public String testMultGet(@RequestParam List<Integer> ids,@RequestParam String name){
        System.out.println(name);
        return "this is a demo";
    }

    @RequestMapping("/users")
    public String testGet1(User users){
        System.out.println(users);
        return "this is a demo";
    }
}
