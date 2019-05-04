package com.example.demo;

import com.example.demo.Controller.ExampleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    /**
     * 用于模拟调用controller的接口
     * 发起请求，在@Test定义的hello
     * 测试用例中，perform函数执行
     * 一次请求调用，accept用于执行
     * 接收的数据类型，andExcept用
     * 于判断接口返回的期望值。
     */
    private MockMvc mvc;

    /**
     * JUnit中定义在测试用例@Test内容执行前预加载的内容
     *这里用来初始化对ExampleController
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new ExampleController()).build();
    }

    @Test
    public void hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello world!")));
    }
}
