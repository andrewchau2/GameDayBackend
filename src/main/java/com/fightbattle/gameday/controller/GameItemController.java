package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public interface GameItemController {
    
    public ResponseEntity<List<GameItemEntity>> getAll();

    public ResponseEntity<GameItemEntity> create(GameItemEntity a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long id);

    public ResponseEntity<GameItemEntity> getById(Long id);
}

