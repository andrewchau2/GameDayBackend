package com.fightbattle.gameday.controller.GameDay;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.util.entities.TestGameDayEntities;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayAndItemUpdateIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameDayService gameDayService;

    @Autowired
    private GameItemService gameItemService;

    @Autowired
    private TestGameDayEntities createGameDay;

    @Autowired
    private TestGameItemEntities createGameItem;

    @Test
    public void testThatAddGameSetItemReturnBadRequest() throws Exception{

        mockMvc.perform(
        MockMvcRequestBuilders.put("/gamedays/9999/games/9999")
        ).andExpect(
            MockMvcResultMatchers.status().isBadRequest()
        );
    }


    @Test
    public void testThatAddGameSetItemReturnOkRequest() throws Exception{
        GameDayEntity gameDay = gameDayService.create(createGameDay.createTestGameDayItemA());
        GameItemEntity gameItem = gameItemService.create(createGameItem.createTestGameA());

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamedays/" + gameDay.getId() + "/games/" + gameItem.getId() + "?type=recentlyPlayed")
        ).andExpect(
            MockMvcResultMatchers.status().isOk()
        );

    }

    // @Test
    // public void testThatAddGameSetItemSuccessfullyAddedToRecentlyPlayed() throws Exception{
    //     GameDayEntity gameDay = gameDayService.create(createGameDay.createTestGameDayItemA());
    //     GameItemEntity gameItem = gameItemService.create(createGameItem.createTestGameA());

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.put("/gamedays/" + gameDay.getId() + "/games/" + gameItem.getId() + "?type=recentlyPlayed")
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$.recentlyPlayed").value(gameDay.getRecentlyPlayed())
    //     );
    // }

    // @Test
    // public void testThatAddGameSetItemSuccessfullyAddedToWishlist(){

    // }
}
