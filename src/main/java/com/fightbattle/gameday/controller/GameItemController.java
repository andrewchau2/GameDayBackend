package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public interface GameItemController {
    
    public ResponseEntity<List<GameItemEntity>> getAll();

    public ResponseEntity<GameItemEntity> create(GameItemEntity a);

    public ResponseEntity<GameItemEntity> delete(Long id);

    public ResponseEntity<GameItemEntity> update(GameItemEntity a, Long id);

    public ResponseEntity<GameItemEntity> getById(Long id);
}

