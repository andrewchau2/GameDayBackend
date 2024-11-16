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

import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
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
    TestGameDayEntities testGameDay;


    // @Test
    // public void testThatGetOneGamePageGetRequestReturns304Found() throws Exception{

    //     String url = "/gamedays/" + gameday.getId();

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.get(url)
    //     ).andExpect(
    //         MockMvcResultMatchers.status().isFound()
    //     );
    // }

    // @Test
    // public void testThatGetOneGamePageGetRequestReturns404NotFound() throws Exception{
    //     String url = "/gamepages/99999";

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.get(url)
    //     ).andExpect(
    //         MockMvcResultMatchers.status().isNotFound()
    //     );
    // }

    // @Test
    // public void testThatGetGamePageListWithNoItemGetRequestReturns204Found() throws Exception{
    //     String url = "/gamepages";

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.get(url)
    //     ).andExpect(
    //         MockMvcResultMatchers.status().isFound()
    //     );
    // }

    // @Test
    // public void testThatGamesListWithItemSuccessfullyFound() throws Exception{

    //     GamePageEntity gamePage = gamePageService.create(
    //         gamePageMapper.mapTo(create.createTestPageA()));
            
        
    //     String url = "/gamepages";

    //     mockMvc.perform(
    //             MockMvcRequestBuilders.get(url)
    //                     .contentType(MediaType.APPLICATION_JSON)
    //     ).andExpect(
    //             MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
    //     ).andExpect(
    //             MockMvcResultMatchers.jsonPath("$[0].steamLink").value(gamePage.getSteamLink())
    //     ).andExpect(
    //             MockMvcResultMatchers.jsonPath("$[0].cdKeyLink").value(gamePage.getCdKeyLink())
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$[0].g2aLink").value(gamePage.getG2aLink())
    //     );
    // }



    // @Test
    // public void testThatGamesListWithItemGetRequestReturns204Found() throws Exception{
    //     List<GamePageDto> insertList = List.of(
    //         create.createTestPageA(),
    //         create.createTestPageB()
    //     );
    //     for (GamePageDto gamePage : insertList) {
    //         gamePageService.create(gamePageMapper.mapTo(gamePage));
    //     }
    //     String url = "/gamepages";

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.get(url)
    //     ).andExpect(
    //         MockMvcResultMatchers.status().isFound()
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$[1].id").isNumber()
    //     );
    // }
}
