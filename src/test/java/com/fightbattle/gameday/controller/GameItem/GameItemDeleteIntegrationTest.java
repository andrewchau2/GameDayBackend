package com.fightbattle.gameday.controller.GameItem;

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
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.util.entities.TestGameItemEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameItemDeleteIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestGameItemEntities create;

    @Autowired
    private GameItemService gameService;

    @Test
    public void testThatGameItemExistsAndDeleteReturns204NoContent() throws Exception{
        GameItemEntity gameItem = create.createTestGameA();
        String gameItemJson = objectMapper.writeValueAsString(gameItem);
        String url = "/games/" + gameItem.getId();
        mockMvc.perform(
            MockMvcRequestBuilders.delete(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gameItemJson)
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }

    @Test
    public void testThatGameItemNotExistAndDeleteReturns204NoContent() throws Exception{
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/games/999")
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }
    
}
