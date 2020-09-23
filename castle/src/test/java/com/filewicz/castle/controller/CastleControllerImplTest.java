package com.filewicz.castle.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CastleControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/TWIERDZA"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("TWIERDZA")));
    }

    @Test
    public void getAllCastlesTest() throws Exception {
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(6)))
                .andExpect(content().string(containsString("BASTION")))
                .andExpect(content().string(containsString("TWIERDZA")))
                .andExpect(content().string(containsString("ZAMEK")))
                .andExpect(content().string(containsString("INFERNO")))
                .andExpect(content().string(containsString("CYTADELA")))
                .andExpect(content().string(containsString("NEKROPOLIA")));
    }
}