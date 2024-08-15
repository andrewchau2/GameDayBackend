package com.fightbattle.gameday.util;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fightbattle.gameday.mapper.GameItemMapper;
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;


@Component
public class CreateTestGameItems {
    
    
    public GameItemMapper mapper;

    @Autowired
    public CreateTestGameItems(GameItemMapper gameItemMapper){
        this.mapper = gameItemMapper;
    }

    public GameItemDto createTestGameA(){
        LocalDate localDate = LocalDate.of(1999,2,13);
        String date = Date.valueOf(localDate).toString();
        GameItemEntity gameItemEntity = GameItemEntity.builder()
                                        .name("street fighter")
                                        .id(1L)
                                        .lastPlayed(date).build();
        return mapper.mapFrom(gameItemEntity);
    }

    public GameItemDto createTestGameB(){
        LocalDate localDate = LocalDate.of(2011,9,21);
        String date = Date.valueOf(localDate).toString();
        GameItemEntity gameItemEntity = GameItemEntity.builder()
                                        .name("7 days to die")
                                        .id(2L)
                                        .lastPlayed(date).build();
        return mapper.mapFrom(gameItemEntity);
    }

    public GameItemDto createTestGameC(){
        LocalDate localDate = LocalDate.now();
        String date = Date.valueOf(localDate).toString();
        GameItemEntity gameItemEntity = GameItemEntity.builder()
                                        .name("minecraft")
                                        .id(3L)
                                        .lastPlayed(date).build();
        return mapper.mapFrom(gameItemEntity);
    }

}
