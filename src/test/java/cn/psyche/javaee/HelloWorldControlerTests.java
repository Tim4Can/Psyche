package cn.psyche.javaee;

import cn.psyche.javaee.controller.HelloWorldController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class HelloWorldControlerTests {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();

    }
    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
