package com.fightbattle.gameday.controller;

import org.springframework.http.ResponseEntity;

import com.fightbattle.gameday.pojo.entity.GamePageEntity;

public interface GameItemAndPageController {
        public ResponseEntity<GamePageEntity> create(Long gameId,  Long pageId);
}
