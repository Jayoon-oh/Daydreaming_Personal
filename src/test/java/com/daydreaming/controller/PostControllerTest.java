package com.daydreaming.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 Hello World를 출력한다.")
    void test() throws Exception {
        // 글 제목
        // 글 내용

        // expected
        mockMvc.perform(get("/posts") // apllicaiton/x-www-form-urlencoded
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"제목입니다.\",\"content\":\"내용입니다.\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andDo(print());
    }
}










