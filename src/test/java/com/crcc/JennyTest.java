//package com.crcc;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.List;
//
///**
// * @author chj
// * @version 1.0
// * @date 2019/12/1 16:49
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class JennyTest {
//
//    @Autowired
//    private WebApplicationContext wac;
//    private MockMvc mockMvc ;
//
//    @Before
//    public void setUp(){
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
//
//
//    @Test
//    public void testView() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/int").param("ids","1","2"))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        System.out.println("test");
//        System.out.println(result);
//    }
//    @Test
//    public void testView1() throws Exception {
//
//        MultiValueMap multiValueMap = new LinkedMultiValueMap(16);
//        multiValueMap.add("id","1");
//        multiValueMap.add("name","jinting");
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users").params(multiValueMap))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//
//        System.out.println("test");
//        System.out.println(result);
//    }
//
//    @Test
//    public void test(){
//        MockMvcRequestBuilders.get("www.baidu.com").param("[1,2,3]");
//    }
//}
