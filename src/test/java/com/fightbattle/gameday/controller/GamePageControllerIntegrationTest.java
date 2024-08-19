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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fightbattle.gameday.mapper.GameItemMapper;
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.util.CreateTestGameItems;
import com.fightbattle.gameday.util.CreateTestPages;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GamePageControllerIntegrationTest {
    
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CreateTestPages testPages;

    @Autowired
    CreateTestGameItems testGames;

    @Autowired
    GameItemService gameItemService;

    @Autowired
    GameItemMapper gameItemMapper;

    @Test
    public void testThatCreateTestPageAReturns200OkStatus() throws Exception{
        GamePageDto gamePageDto = testPages.CreateTestPageA();
        String gamePageJson = objectMapper.writeValueAsString(gamePageDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamepages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }


    @Test
    public void testThatCreateTestPageASuccessfullyCreated() throws Exception{
        GameItemDto gameItemDto = testGames.createTestGameA();
        GameItemEntity created = gameItemService.create(gameItemMapper.mapTo(gameItemDto));
        GamePageDto gamePageDto = testPages.CreateTestPageA();
        String gamePageJson = objectMapper.writeValueAsString(gamePageDto);
        String url = "/games/" + created.getId().toString() + "/gamepages";
        mockMvc.perform(
            MockMvcRequestBuilders.put(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.steamLink").value(gamePageDto.getSteamLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.g2aLink").value(gamePageDto.getG2aLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.cdKeyLink").value(gamePageDto.getCdKeyLink())
        );
    }


    @Test
    public void testThatCreateTestPageBSuccessfullyCreated() throws Exception{
        GamePageDto gamePageDto = testPages.CreateTestPageB();
        String gamePageJson = objectMapper.writeValueAsString(gamePageDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamepages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.steamLink").value(gamePageDto.getSteamLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.g2aLink").value(gamePageDto.getG2aLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.cdKeyLink").value(gamePageDto.getCdKeyLink())
        );
    }


    @Test
    public void testThatCreateTestPageNullSuccessfullyCreated() throws Exception{
        GamePageDto gamePageDto = testPages.CreateTestPageNull();
        String gamePageJson = objectMapper.writeValueAsString(gamePageDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamepages")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.steamLink").value(gamePageDto.getSteamLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.g2aLink").value(gamePageDto.getG2aLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.cdKeyLink").value(gamePageDto.getCdKeyLink())
        );
    }


}
