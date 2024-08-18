package com.fightbattle.gameday.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fightbattle.gameday.mapper.GameDayMapper;
import com.fightbattle.gameday.pojo.dto.GameDayDto;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;

@Component
public class CreateTestGameDayItems {
    
    @Autowired
    GameDayMapper gameDayMapper;
    
    public GameDayDto createTestGameDayItemA(){
        GameDayEntity gameDayEntity = GameDayEntity.builder()
        .description("Test description")
        .nextGameDay("2024-07-11")
        .serverName("chicken")
        .build();

        GameDayDto gameDayDto = gameDayMapper.mapFrom(gameDayEntity);
        return gameDayDto;
    }

    public GameDayDto createTestGameDayItemB(){
        GameDayEntity gameDayEntity = GameDayEntity.builder()
        .description("Test description")
        .nextGameDay("2024-07-11")
        .serverName("can-opener")
        .build();

        GameDayDto gameDayDto = gameDayMapper.mapFrom(gameDayEntity);
        return gameDayDto;
    }


    public GameDayDto createTestGameDayItemNull(){
        GameDayEntity gameDayEntity = GameDayEntity.builder()
        .build();

        GameDayDto gameDayDto = gameDayMapper.mapFrom(gameDayEntity);
        return gameDayDto;
    }

}
