package com.crcc;

import com.crcc.controller.GoodsController;
import com.crcc.dao.entity.Goods;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavastudyApplicationTests {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc ;
    @Autowired
    private GoodsController goodsController;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void testA(){
        Goods goods=new Goods(1,"ss","aa");
        goodsController.addGoods(goods);
        System.out.println("测试成功");
    }

    @Test
    public void testFail(){
        System.out.println("测试失败示例");
        System.out.println(1/0);
    }

}
