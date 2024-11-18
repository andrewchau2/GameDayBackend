package com.fightbattle.gameday.util.entities;

import org.springframework.stereotype.Component;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;

@Component
public class TestGamePageEntities {
        public GamePageEntity createTestPageA(){
        return GamePageEntity.builder()
        .steamLink("https://store.steampowered.com/app/1676840/For_The_King_II/")
        .cdKeyLink("https://www.cdkeys.com/for-the-king-ii-pc-steam")
        .g2aLink("https://www.g2a.com/for-the-king-ii-pc-steam-key-global-i10000501037003")
        .build();
    }


    public GamePageEntity createTestPageB(){
        return GamePageEntity.builder()
        .steamLink("https://store.steampowered.com/app/1217060/Gunfire_Reborn/")
        .cdKeyLink("https://www.cdkeys.com/gunfire-reborn-pc-steam")
        .g2aLink("https://www.g2a.com/gunfire-reborn-pc-steam-key-global-i10000195949003")
        .build();
    }

    public GamePageEntity createTestPageNull(){
        return GamePageEntity.builder().build();
    }
}
