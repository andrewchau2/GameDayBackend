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
public class GameItemUpdateIntegrationTest {

    @Autowired
    private TestGameItemEntities create;

    @Autowired
    private GameItemService gameItemService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testThatUpdateGameASuccessfullyUpdated() throws Exception{
        GameItemEntity gameItem = gameItemService.create(create.createTestGameA());
        gameItem.setName("Street Fighter 2");
        gameItem.setGenre("Clicker");
        gameItem.setLastPlayed("2000-11-13");

        String gameJson = objectMapper.writeValueAsString(gameItem);
        System.out.println(gameJson);

        mockMvc.perform(
            MockMvcRequestBuilders.post("/games/" + gameItem.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value("street fighter 2")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.genre").value("Clicker")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value("2000-11-13")
        );
    }
}
