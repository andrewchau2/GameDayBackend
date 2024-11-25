package com.fightbattle.gameday.controller.GameItem;

import java.util.List;

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

import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameItemGetIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    TestGameItemEntities create;

    @Autowired
    GameItemService gameService;

    @Test
    public void testThatGetOneGameItemGetRequestReturns304Found() throws Exception{
        GameItemEntity gameItem = gameService.create(create.createTestGameA());
        String url = "/games/" + gameItem.getId();

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGetOneGameItemGetRequestReturns404NotFound() throws Exception{
        String url = "/games/99999";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatGetGamesListWithNoItemGetRequestReturns204Found() throws Exception{
        String url = "/games";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGamesListWithItemSuccessfullyFound() throws Exception{

       gameService.create(create.createTestGameA());
        
        String url = "/games";

        mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].name").value("street fighter")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].genre").value("Fighter")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].lastPlayed").value("1999-02-13")
        );
    }



    @Test
    public void testThatGamesListWithItemGetRequestReturns204Found() throws Exception{
        List<GameItemEntity> insertList = List.of(
            create.createTestGameA(),
            create.createTestGameB(),
            create.createTestGameC()
        );
        for (GameItemEntity gameItem : insertList) {
            gameService.create(gameItem);
        }
        String url = "/games";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[1].id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[2].id").isNumber()
        );
    }
}
