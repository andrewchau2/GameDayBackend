package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;

public interface GamePageController{
    public ResponseEntity<List<GamePageEntity>> getAll();

    //public ResponseEntity<GamePageEntity> create(Long gameItemId, GamePageEntity gamePage);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long gameId,Long gamePageId);

    public ResponseEntity<GamePageEntity> getById(Long id);
}
