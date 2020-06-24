package com.twschool.practice.domain.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ContextConfiguration
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class GuessControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_response_when_call_guess_number() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/games/guess-number")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"number\": \"1 2 3 4\",\"userId\": \"113\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("4A0B"));

    }

}
