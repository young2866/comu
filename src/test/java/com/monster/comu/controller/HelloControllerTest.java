package com.monster.comu.controller;

import com.monster.comu.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class,
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;



    @Test
    @WithMockUser
    public void hello_Test() throws Exception {
        String hello = "hello Spring Boot!";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser
    public void helloDto_Test() throws Exception {
        String name = "abc";
        String nickname = "def";

        mvc.perform(
                get("/hello/dto")
                                .param("name", name)
                                .param("nickname", nickname))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.nickname", is(nickname)));
    }


}