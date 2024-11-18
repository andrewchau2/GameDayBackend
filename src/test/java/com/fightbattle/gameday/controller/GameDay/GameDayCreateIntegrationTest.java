package com.fightbattle.gameday.controller.GameDay;

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
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.util.entities.TestGameDayEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayCreateIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestGameDayEntities create;

    @Test
    public void testThatGameDayPutRequestReturns200StatusOk() throws Exception{
        GameDayEntity gameDay = create.createTestGameDayItemA();
        String gameDayJson = objectMapper.writeValueAsString(gameDay);

        mockMvc.perform(
        MockMvcRequestBuilders.put("/gamedays")
        .contentType(MediaType.APPLICATION_JSON)
        .content(gameDayJson))
        .andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatGameDayASuccessfullyCreated() throws Exception{
        GameDayEntity gameDay = create.createTestGameDayItemA();
        String gameDayJson = objectMapper.writeValueAsString(gameDay);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamedays")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gameDayJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.serverName").value(gameDay.getServerName())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.description").value(gameDay.getDescription())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.nextGameDay").value(gameDay.getNextGameDay())
        );
    }


    @Test
    public void testThatGameDayBSuccessfullyCreated() throws Exception{
        GameDayEntity gameDay = create.createTestGameDayItemA();
        String gameDayJson = objectMapper.writeValueAsString(gameDay);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamedays")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gameDayJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.serverName").value(gameDay.getServerName())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.description").value(gameDay.getDescription())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.nextGameDay").value(gameDay.getNextGameDay())
        );
    }

    @Test
    public void testThatGameDayNullSuccessfullyCreated() throws Exception{
        GameDayEntity gameDay = create.createTestGameDayItemNull();
        String gameDayJson = objectMapper.writeValueAsString(gameDay);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/gamedays")
            .contentType(MediaType.APPLICATION_JSON)
            .content(gameDayJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.serverName").value(gameDay.getServerName())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.description").value(gameDay.getDescription())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.nextGameDay").value(gameDay.getNextGameDay())
        );
    }
}
