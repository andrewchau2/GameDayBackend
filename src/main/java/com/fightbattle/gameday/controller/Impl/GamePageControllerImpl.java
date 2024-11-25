package com.fightbattle.gameday.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.GamePageController;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;

@RestController
public class GamePageControllerImpl implements GamePageController{

    @Autowired
    private GamePageService gamePageService;

    @Autowired
    private GameItemService gameItemService;

    @GetMapping(path="/gamepages")
    public ResponseEntity<List<GamePageEntity>> getAll() {
        List<GamePageEntity> res = gamePageService.findAll().stream().toList();
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    @PutMapping(path="/games/{id}/gamepages")
    public ResponseEntity<GamePageEntity> create(
        @PathVariable(name="id") Long gameItemId, 
        @RequestBody GamePageEntity gamePage) {
        GameItemEntity gameItemEntity = gameItemService.find(gameItemId);

        GamePageEntity created = gamePageService.create(gamePage);
        gameItemEntity.setGamePage(created);
        gameItemService.fullUpdate(gameItemEntity);
        
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping(path="/games/{gameId}/gamepages/{gamePageId}")
    public ResponseEntity delete(
        @PathVariable(name="gameId") Long gameId,
        @PathVariable(name="gamePageId") Long gamePageId) {
            //Removing dependicies
            GameItemEntity gameItemEntity = gameItemService.find(gameId);
            gameItemEntity.setGamePage(null);
            gameItemService.fullUpdate(gameItemEntity);

            gamePageService.delete(gamePageId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path="/gamepages/{id}")
    public ResponseEntity<GamePageEntity> getById(@PathVariable("id") Long id) {
        GamePageEntity gamePageEntity = gamePageService.find(id);
 
        if(gamePageEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(gamePageEntity, HttpStatus.FOUND);
        } 
    }
}
