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
import com.fightbattle.gameday.util.entities.TestGameItemEntities;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameItemCreateIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestGameItemEntities createGames;


    @Test
    public void testThatCreateGameSuccessfullyReturns201Created() throws Exception{
        GameItemEntity gameItem = createGames.createTestGameA();


        gameItem.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItem);
        
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
        GameItemEntity gameItem = createGames.createTestGameA();

        gameItem.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItem);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItem.getName())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItem.getLastPlayed())
        );
        
    }


    @Test
    public void testThatCreateGameBSuccessfullyCreated() throws Exception{
        GameItemEntity gameItem = createGames.createTestGameB();
        System.out.println(gameItem);

        gameItem.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItem);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItem.getName())
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItem.getLastPlayed())
        );
        
        
    }

    @Test
    public void testThatCreateGameCSuccessfullyCreated() throws Exception{
        GameItemEntity gameItem = createGames.createTestGameC();

        gameItem.setId(null); //Id is auto-generated
        String gameJson = objectMapper.writeValueAsString(gameItem);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gameJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(gameItem.getName())
         ).andExpect(
            MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItem.getLastPlayed())
        );
    }


    // @Test
    // public void testThatCreateGameNullSuccessfullyCreated() throws Exception{
    //     GameItemEntity gameItem = createGames.createTestGameNull();

    //     gameItem.setId(null); //Id is auto-generated
    //     String gameJson = objectMapper.writeValueAsString(gameItem);

    //     mockMvc.perform(
    //         MockMvcRequestBuilders.put("/games")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(gameJson)
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$.id").isNumber()
    //     ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$.name").value(gameItem.getName())
    //      ).andExpect(
    //         MockMvcResultMatchers.jsonPath("$.lastPlayed").value(gameItem.getLastPlayed())
    //     );
    // }



}
