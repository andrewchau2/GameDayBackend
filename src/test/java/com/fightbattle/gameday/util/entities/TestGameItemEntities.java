package com.fightbattle.gameday.util.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;

@Component
public class TestGameItemEntities {
        public GameItemEntity createTestGameA(){
        LocalDate localDate = LocalDate.of(1999,2,13);
        String date = Date.valueOf(localDate).toString();
        GameItemEntity game =  GameItemEntity.builder()
                            .name("street fighter")
                            .genre("Fighter")
                            .id(2L)
                            .lastPlayed(date).build();
        //game.getStorePages().put("steam", "5");
        return game;
        }

    public GameItemEntity createTestGameB(){
        LocalDate localDate = LocalDate.of(2011,9,21);
        String date = Date.valueOf(localDate).toString();
        return GameItemEntity.builder()
                            .name("7 days to die")
                            .genre("Survival")
                            .id(2L)
                            .lastPlayed(date).build();
    }

    public GameItemEntity createTestGameC(){
        LocalDate localDate = LocalDate.now();
        String date = Date.valueOf(localDate).toString();
        return GameItemEntity.builder()
                            .name("minecraft")
                            .genre("Survival")
                            .id(3L)
                            .lastPlayed(date).build();
    }

    public GameItemEntity createTestGameNull(){
        return GameItemEntity.builder().build();
    }
}
