package com.fightbattle.gameday.controller.GameDay;

import javax.print.attribute.standard.Media;

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
import com.fightbattle.gameday.mapper.GameDayMapper;
import com.fightbattle.gameday.pojo.dto.GameDayDto;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.util.CreateTestGameDayItems;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class GameDayDeleteIntegrationTest {
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CreateTestGameDayItems create;
    
    @Autowired
    GameDayService gameDayService;

    @Autowired
    GameDayMapper gMapper;

    @Test
    public void testThatGameDayDeleteExistsAndRequestReturns204NotFound() throws Exception{
        GameDayDto gameDayDto = create.createTestGameDayItemA();
        
        String gameDayJson = objectMapper.writeValueAsString(gameDayDto);
        GameDayEntity gameDayEntity = gMapper.mapTo(gameDayDto);
        GameDayEntity output = gameDayService.create(gameDayEntity);
        String url = "/gamedays/" + output.getId();
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(gameDayJson)
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }


    @Test
    public void testThatGameDayDeleteNotExistsAndRequestReturns204NotFound() throws Exception{
        String url = "/gamedays/9999";
        
        mockMvc.perform(
            MockMvcRequestBuilders.delete(url)
        ).andExpect(
            MockMvcResultMatchers.status().isNoContent()
        );
    }
}
