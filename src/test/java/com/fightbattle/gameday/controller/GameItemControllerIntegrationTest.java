package com.fightbattle.gameday.controller;

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
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.util.CreateTestGameItems;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameItemControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CreateTestGameItems createGames;


    @Test
    public void testThatCreateGameSuccessfullyReturns201Created() throws Exception{
        GameItemDto gameItemDto = createGames.createTestGameA();
        System.out.println(gameItemDto);

        gameItemDto.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItemDto);
        
        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
        
    }

    @Test
    public void testThatCreateGameASuccessfullyCreated() throws Exception{
        GameItemDto gameItemDto = createGames.createTestGameA();
        System.out.println(gameItemDto);

        gameItemDto.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItemDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItemDto.getName())

            ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItemDto.getLastPlayed())
        );
        
    }


    @Test
    public void testThatCreateGameBSuccessfullyCreated() throws Exception{
        GameItemDto gameItemDto = createGames.createTestGameB();
        System.out.println(gameItemDto);

        gameItemDto.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItemDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItemDto.getName())

            ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItemDto.getLastPlayed())
        );
        
        
    }

    @Test
    public void testThatCreateGameCSuccessfullyCreated() throws Exception{
        GameItemDto gameItemDto = createGames.createTestGameC();
        System.out.println(gameItemDto);

        gameItemDto.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItemDto);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItemDto.getName())

            ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItemDto.getLastPlayed())
        );
        
        
    }



}
