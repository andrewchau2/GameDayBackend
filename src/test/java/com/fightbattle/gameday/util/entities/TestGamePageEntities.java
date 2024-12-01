package com.fightbattle.gameday.util.entities;

import org.springframework.stereotype.Component;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;

@Component
public class TestGamePageEntities {
        public GamePageEntity createTestPageA(){
        return GamePageEntity.builder()
            .gameLink("https://store.steampowered.com/app/1217060/Gunfire_Reborn/")
        .build();
    }


    public GamePageEntity createTestPageB(){
        return GamePageEntity.builder()
        .gameLink("https://www.cdkeys.com/gunfire-reborn-pc-steam")
        .build();
    }

    public GamePageEntity createTestPageNull(){
        return GamePageEntity.builder().build();
    }
}