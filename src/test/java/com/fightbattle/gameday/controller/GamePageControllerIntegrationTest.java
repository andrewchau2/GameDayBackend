package com.fightbattle.gameday.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.service.GamePageService;
import com.fightbattle.gameday.util.CreateTestPages;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GamePageControllerIntegrationTest {
    
    @Autowired
    private GamePageService gamePageService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CreateTestPages testPages;


    @Test
    public void testThatCreateTestPageAReturns200OkStatus() throws Exception{
        GamePageDto gamePageDto = testPages.CreateTestPageA();
        String res = objectMapper.writeValueAsString(gamePageDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamepages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(res)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }


    @Test
    public void testThatCreateTestPageASuccessfullyCreated() throws Exception{
        GamePageDto gamePageDto = testPages.CreateTestPageA();
        String res = objectMapper.writeValueAsString(gamePageDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamepages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(res)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        );
    }


    @Test
    public void testThatCreateTestPageBSuccessfullyCreated(){

    }


    @Test
    public void testThatCreateTestPageNullSuccessfullyCreated(){

    }


}
