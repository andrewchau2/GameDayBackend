package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.dto.GamePageDto;

public interface GamePageController{
    public ResponseEntity<List<GamePageDto>> getAll();

    public ResponseEntity<GamePageDto> create(Long gameItemId, GamePageDto gamePageDto);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long gameId,Long gamePageId);

    public ResponseEntity<GamePageDto> getById(Long id);
}
