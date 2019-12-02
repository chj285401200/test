package com.crcc.GoodsTest;

import com.alibaba.fastjson.JSON;
import com.crcc.dao.entity.Goods;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author chj
 * @version 1.0
 * @date 2019/12/1 16:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GoodsTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc ;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        Goods goods = new Goods(3,"手机","www.baidu.com");

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/goods").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(JSON.toJSONString(goods)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testInsertGoods() throws Exception {
        Goods goods = new Goods(5,"手机2","www.jd.com");


        String result = mockMvc.perform(MockMvcRequestBuilders.post("/goods").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(goods)))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        System.out.println("test");
        System.out.println(result);
    }
    @Test
    public void testGetGoods() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/goods").param("id","3"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        /*MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders.get("/goods").param("id","1"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/

        System.out.println("test");
        System.out.println(result);

    }


}
