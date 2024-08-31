package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.dto.GameDayDto;

public interface GameDayController {
    public ResponseEntity<List<GameDayDto>> getAll();

    public ResponseEntity<GameDayDto> create(GameDayDto a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long id);

    public ResponseEntity<GameDayDto> getById(Long id);
}
