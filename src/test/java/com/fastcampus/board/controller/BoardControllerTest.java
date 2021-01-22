package com.fastcampus.board.controller;

import com.fastcampus.board.dto.BoardDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class BoardControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .alwaysDo(print())
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void getList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/posts"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getBoard() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.writer").value("최유선"))
                .andExpect(jsonPath("$.title").value("게시판프로젝트1"))
                .andExpect(jsonPath("$.content").value("프로젝트1"));
    }

    @Test
    void writeBoard() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/post")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new BoardDto(null, "최유선", "게시판프로젝트8", "프로젝트8", null ))))
                .andExpect(status().isOk());
    }

    @Test
    void updateBoard() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/post/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new BoardDto(4L, "최유선", "게시판프로젝트4444", "프로젝트4444", null ))))
                .andExpect(status().isOk());
    }

    @Test
    void deleteBoard () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/post/delete/14")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                        objectMapper.writeValueAsString(
                                new BoardDto(14L, "", "", "", null ))))
                .andExpect(status().isOk());
    }
}