package com.fightbattle.gameday.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.GameItemAndPageController;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;


@RestController
public class GameItemNPageCtrlImpl implements GameItemAndPageController {
    @Autowired
    private GamePageService gamePageService;

    @Autowired
    private GameItemService gameItemService;

    @PutMapping(path="/games/{gameId}/gamepages/{pageId}")
    public ResponseEntity<GamePageEntity> create(
        @PathVariable(name="gameId") Long gameId, 
        @PathVariable(name="pageId") Long pageId) {
        GameItemEntity gameItem = gameItemService.find(gameId);
        GamePageEntity gamePage = gamePageService.find(pageId);

        if(gameItem == null || gamePage == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        gamePage.setGameItem(gameItem);
        gameItem.getGamePages().add(gamePage);
        gamePageService.fullUpdate(gamePage);
        gameItemService.fullUpdate(gameItem);
        
        return new ResponseEntity<>(gamePage, HttpStatus.CREATED);
    }
}
