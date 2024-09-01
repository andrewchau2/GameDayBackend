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
import com.fightbattle.gameday.mapper.GamePageMapper;
import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;
import com.fightbattle.gameday.util.dtos.TestGamePageDtos;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GamePageDeleteIntegrationTest {
    
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    GamePageMapper gMapper;

    @Autowired
    GamePageService gamePageService;

    @Autowired
    TestGamePageDtos createPages;

    @Autowired
    TestGameItemEntities createGame;

    @Autowired
    GameItemService gameItemService;

    @Test
    public void testThatGameDayDeleteExistsAndRequestReturns204NotFound() throws Exception{
        GameItemEntity gameItem = createGame.createTestGameA();
        GameItemEntity createdGame = gameItemService.create(gameItem);

        GamePageDto gamePageDto = createPages.createTestPageA();
        String gamePageJson = objectMapper.writeValueAsString(gamePageDto);
        GamePageEntity gamePageEntity = gMapper.mapTo(gamePageDto);
        GamePageEntity output = gamePageService.create(gamePageEntity);
        String url = "/games/" + createdGame.getId() + "/gamepages/" + output.getId();
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gamePageJson)
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }
}
