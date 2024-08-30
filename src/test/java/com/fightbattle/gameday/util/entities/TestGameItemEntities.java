package com.fightbattle.gameday.util.entities;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;

@Component
public class TestGameItemEntities {
        public GameItemEntity createTestGameA(){
        LocalDate localDate = LocalDate.of(1999,2,13);
        String date = Date.valueOf(localDate).toString();
        return GameItemEntity.builder()
                            .name("street fighter")
                            .id(2L)
                            .lastPlayed(date).build();
    }

    public GameItemEntity createTestGameB(){
        LocalDate localDate = LocalDate.of(2011,9,21);
        String date = Date.valueOf(localDate).toString();
        return GameItemEntity.builder()
                            .name("7 days to die")
                            .id(2L)
                            .lastPlayed(date).build();
    }

    public GameItemEntity createTestGameC(){
        LocalDate localDate = LocalDate.now();
        String date = Date.valueOf(localDate).toString();
        return GameItemEntity.builder()
                            .name("minecraft")
                            .id(3L)
                            .lastPlayed(date).build();
    }

    public GameItemEntity createTestGameNull(){
        return GameItemEntity.builder().build();
    }
}
