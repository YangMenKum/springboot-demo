package com.example.demo.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 单个类拦截器
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SingleClassTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        // 单个类  拦截器无效（controller内部依赖的Bean不会注入）
        mvc = MockMvcBuilders.standaloneSetup(new ExampleController()).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * 无Bean调用-成功
     * @throws Exception
     */
    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /**
     * 有Bean调用-失败
     * @throws Exception
     */
    @Test
    public void serviceBean() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/serviceBean")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
