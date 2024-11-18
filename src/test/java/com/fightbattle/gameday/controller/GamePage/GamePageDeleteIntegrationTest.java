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
import com.fightbattle.gameday.service.GamePageService;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;
import com.fightbattle.gameday.util.entities.TestGamePageEntities;

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
    GamePageService gamePageService;

    @Autowired
    TestGamePageEntities createPages;

    @Autowired
    TestGameItemEntities createGame;

    @Autowired
    GameItemService gameItemService;

    @Test
    public void testThatGameDayDeleteExistsAndRequestReturns204NotFound() throws Exception{
        GameItemEntity gameItem = createGame.createTestGameA();
        GameItemEntity createdGame = gameItemService.create(gameItem);

        GamePageEntity gamePage = createPages.createTestPageA();
        String gamePageJson = objectMapper.writeValueAsString(gamePage);
        GamePageEntity output = gamePageService.create(gamePage);
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
