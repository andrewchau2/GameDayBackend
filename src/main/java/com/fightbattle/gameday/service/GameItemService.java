package com.fightbattle.gameday.service;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public interface GameItemService extends DefaultService<GameItemEntity> {
    public GameItemEntity findByName(String name);
}
