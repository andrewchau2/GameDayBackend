package com.fightbattle.gameday.service;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public interface GameItemService {
    
    public GameItemEntity find(Long id);

    public void delete(Long id);

    public GameItemEntity partialUpdate(Long id, GameItemEntity gameItemEntity);

    public GameItemEntity fullUpdate(GameItemEntity gameItemEntity);

    public GameItemEntity create(GameItemEntity gameItemEntity);
}
