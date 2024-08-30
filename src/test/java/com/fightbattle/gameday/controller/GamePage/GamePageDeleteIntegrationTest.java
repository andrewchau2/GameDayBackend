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
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;
import com.fightbattle.gameday.util.dtos.TestGameItemDtos;
import com.fightbattle.gameday.util.dtos.TestGamePageDtos;

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
    TestGameItemDtos createGame;

    @Autowired
    GameItemService gameItemService;

    // @Test
    // public void testThatGameDayDeleteExistsAndRequestReturns204NotFound() throws Exception{
    //     GameItemDto gameItemDto = createGame.createTestGameA();
    //     GamePageDto gamePageDto = createPages.CreateTestPageA();
        
    //     String gameDayJson = objectMapper.writeValueAsString(gamePageDto);
    //     GamePageEntity gamePageEntity = gMapper.mapTo(gamePageDto);
    //     gameItemService.create(null);
    //     GameDayEntity output = service.create(gamePageEntity);
    //     String url = "/gamedays/" + output.getId();
        
    //     mockMvc.perform(
    //         MockMvcRequestBuilders.delete(url)
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .content(gameDayJson)
    //     ).andExpect(
    //         MockMvcResultMatchers.status().isNoContent()
    //     );
    // }

    @Test
    public void testThatGamePageDeleteNotExistsAndRequestReturns204NotFound() throws Exception{
        String url = "/gamedays/9999";
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(url)
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }

}
