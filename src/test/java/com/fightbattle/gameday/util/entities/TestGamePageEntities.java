package com.fightbattle.gameday.util.entities;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;

public class TestGamePageEntities {
    public GameDayEntity createTestGameDayItemA(){
        return GameDayEntity.builder()
        .description("Test description")
        .nextGameDay("2024-07-11")
        .serverName("chicken")
        .build();
    }

    public GameDayEntity createTestGameDayItemB(){
        return GameDayEntity.builder()
        .description("Test description")
        .nextGameDay("2024-07-11")
        .serverName("can-opener")
        .build();
    }


    public GameDayEntity createTestGameDayItemNull(){
        return GameDayEntity.builder().build();
    }
}