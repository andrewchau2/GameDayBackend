package com.fightbattle.gameday.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public interface GameDayAndItemController {
    
    @SuppressWarnings("rawtypes")
    public ResponseEntity deleteGameDaySetItem(Long gameDayID, Long gameItemID,String type);

    public ResponseEntity<GameItemEntity> addGameDaySetItem(Long gameDayID, Long gameItemID,String type);

    public ResponseEntity<Set<GameItemEntity>> getGameDaySetItem(Long gameDayID, Long gameItemID,String type);

}
