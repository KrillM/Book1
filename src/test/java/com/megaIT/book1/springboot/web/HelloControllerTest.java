package com.megaIT.book1.springboot.web;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest{
    @Autowired
    private MockMvc mm;
    @Test
    public void helloReturn() throws Exception{
        String hello = "hello";

        mm.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @Test
    public void helloControllerDtoReturn() throws Exception{
        String name = "hello";
        int amount = 1000;

        // jsonPath : Json 응답값을 필드별로 검증할 수 있는 method
        //          $를 기준으로 필드명을 명시 (This is a reason why developer uses $ in view)
        //          name -> $.name / amount -> $.amount
        mm.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is(name)))
                .andExpect(jsonPath( "$.amount",Matchers.is(amount)));
    }
}