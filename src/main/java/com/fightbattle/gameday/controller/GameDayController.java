package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;

public interface GameDayController {
    public ResponseEntity<List<GameDayEntity>> getAll();

    public ResponseEntity<GameDayEntity> getById(Long id);

    public ResponseEntity<GameDayEntity> create(GameDayEntity a);

    public ResponseEntity<GameDayEntity> fullUpdate(GameDayEntity newGameDay, Long id);

    public ResponseEntity<GameDayEntity> delete(Long id);

}
