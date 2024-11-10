package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;

public interface GameDayController {
    public ResponseEntity<List<GameDayEntity>> getAll();

    public ResponseEntity<GameDayEntity> create(GameDayEntity a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long id);

    public ResponseEntity<GameDayEntity> getById(Long id);
}
