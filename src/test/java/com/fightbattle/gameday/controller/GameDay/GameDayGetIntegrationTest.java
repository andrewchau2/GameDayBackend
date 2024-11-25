package com.fightbattle.gameday.controller.GameDay;

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

import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.util.entities.TestGameDayEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayGetIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Autowired
    GameDayService gameDayService;

    @Autowired
    TestGameDayEntities create;


    @Test
    public void testThatGetOneGamePageGetRequestReturns302Found() throws Exception{
        GameDayEntity gameday = create.createTestGameDayItemA(); 
        gameDayService.create(gameday);
        String url = "/gamedays/" + gameday.getId();

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGetOneGamePageGetRequestReturns404NotFound() throws Exception{
        String url = "/gamedays/99999";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatGetGamePageListWithNoItemGetRequestReturns204Found() throws Exception{
        String url = "/gamedays";

        mockMvc.perform(
            MockMvcRequestBuilders.get(url)
        ).andExpect(
            MockMvcResultMatchers.status().isFound()
        );
    }

    @Test
    public void testThatGamesListWithItemSuccessfullyFound() throws Exception{

        gameDayService.create(create.createTestGameDayItemA());
            
        
        String url = "/gamedays";

        mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].description").value("Test description")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].nextGameDay").value("2024-07-11")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].serverName").value("chicken")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].recentlyPlayed").isEmpty()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$[0].wishlist").isEmpty()
        );
    }



    @Test
    public void testThatGamesListWithItemGetRequestReturns204Found() throws Exception{
        List<GameDayEntity> insertList = List.of(
            create.createTestGameDayItemA(),
            create.createTestGameDayItemB()
        );
        for (GameDayEntity gameDay : insertList) {
            gameDayService.create(gameDay);
        }
        String url = "/gamedays";

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
