package com.fightbattle.gameday.controller.GamePage;

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
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;
import com.fightbattle.gameday.util.entities.TestGamePageEntities;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GamePageCreateIntegrationTest {
    
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestGamePageEntities testPages;

    @Autowired
    TestGameItemEntities testGames;

    @Autowired
    GameItemService gameItemService;

    @Test
    public void testThatCreateTestPageAReturns200OkStatus() throws Exception{
        GameItemEntity gameItem = testGames.createTestGameA();
        GameItemEntity created = gameItemService.create(gameItem);
        GamePageEntity gamePage = testPages.createTestPageA();
        String gamePageJson = objectMapper.writeValueAsString(gamePage);
        String url = "/games/" + created.getId().toString() + "/gamepages";
        mockMvc.perform(
            MockMvcRequestBuilders.put(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }


    @Test
    public void testThatCreateTestPageASuccessfullyCreated() throws Exception{
        GameItemEntity gameItem = testGames.createTestGameA();
        GameItemEntity created = gameItemService.create(gameItem);
        GamePageEntity gamePageDto = testPages.createTestPageA();
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
        GameItemEntity gameItem = testGames.createTestGameA();
        GameItemEntity created = gameItemService.create(gameItem);
        GamePageEntity gamePageDto = testPages.createTestPageB();
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
    public void testThatCreateTestPageNullSuccessfullyCreated() throws Exception{
        GameItemEntity gameItem = testGames.createTestGameA();
        GameItemEntity created = gameItemService.create(gameItem);
        GamePageEntity gamePage = testPages.createTestPageNull();
        String gamePageJson = objectMapper.writeValueAsString(gamePage);
        String url = "/games/" + created.getId().toString() + "/gamepages";

        mockMvc.perform(
            MockMvcRequestBuilders.put(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.steamLink").value(gamePage.getSteamLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.g2aLink").value(gamePage.getG2aLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.cdKeyLink").value(gamePage.getCdKeyLink())
        );
    }


}
