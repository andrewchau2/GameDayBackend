package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fightbattle.gameday.pojo.dto.GameItemDto;

public interface GameItemController {
    
    public ResponseEntity<List<GameItemDto>> getAll();

    public ResponseEntity<GameItemDto> create(GameItemDto a);

    @SuppressWarnings("rawtypes")
    public ResponseEntity delete(Long id);

    public ResponseEntity<GameItemDto> getById(Long id);
}

