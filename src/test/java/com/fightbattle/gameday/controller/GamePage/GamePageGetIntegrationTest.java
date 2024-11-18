package com.fightbattle.gameday.controller.GamePage;

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
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;
import com.fightbattle.gameday.util.entities.TestGamePageEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GamePageGetIntegrationTest {


    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private GamePageService gamePageService;

    @Autowired
    private TestGamePageEntities create;

    @Autowired
    private TestGameItemEntities gameCreate;
   
   @Autowired
   private GameItemService gameItemService;

    @Test
    public void testThatGetOneGamePageGetRequestReturns304Found() throws Exception{
        
        GameItemEntity gameItem = gameCreate.createTestGameA();
        GamePageEntity gamePage =  create.createTestPageA();
        gameItem.setGamePage(gamePage);
        gamePage.setGameItemEntity(gameItem);
        
        gameItem = gameItemService.create(gameItem);
        gamePage = gamePageService.create(gamePage);

        String url = "/gamepages/" + gamePage.getId();

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGetOneGamePageGetRequestReturns404NotFound() throws Exception{
        String url = "/gamepages/99999";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatGetGamePageListWithNoItemGetRequestReturns204Found() throws Exception{
        String url = "/gamepages";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGamesListWithItemSuccessfullyFound() throws Exception{

        GamePageEntity gamePage = gamePageService.create(create.createTestPageA());
            
        
        String url = "/gamepages";

        mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].steamLink").value(gamePage.getSteamLink())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].cdKeyLink").value(gamePage.getCdKeyLink())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].g2aLink").value(gamePage.getG2aLink())
        );
    }



    @Test
    public void testThatGamesListWithItemGetRequestReturns204Found() throws Exception{
        List<GamePageEntity> insertList = List.of(
            create.createTestPageA(),
            create.createTestPageB()
        );
        for (GamePageEntity gamePage : insertList) {
            gamePageService.create(gamePage);
        }
        String url = "/gamepages";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[1].id").isNumber()
        );
    }
}
