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
import com.fightbattle.gameday.mapper.GamePageMapper;
import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GameItemService;
import com.fightbattle.gameday.service.GamePageService;

@RestController
public class GamePageControllerImpl implements GamePageController{

    @Autowired
    private GamePageService gamePageService;
    
    @Autowired
    private GamePageMapper gamePageMapper;

    @Autowired
    private GameItemService gameItemService;

    @GetMapping(path="/gamepages")
    public ResponseEntity<List<GamePageDto>> getAll() {
        List<GamePageDto> res = gamePageService.findAll().stream().map(gamePageMapper::mapFrom).toList();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping(path="/games/{id}/gamepages")
    public ResponseEntity<GamePageDto> create(
        @PathVariable(name="id") Long gameItemId, 
        @RequestBody GamePageDto gamePageDto) {
        System.out.println("Running\n\n\n");
        GameItemEntity gameItemEntity = gameItemService.find(gameItemId);

        GamePageEntity res = gamePageMapper.mapTo(gamePageDto);
        GamePageDto created = gamePageMapper.mapFrom(gamePageService.create(res));
        gameItemEntity.setGamePage(res);
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
    public ResponseEntity<GamePageDto> getById(@PathVariable("id") Long id) {
        GamePageEntity gamePageEntity = gamePageService.find(id);
 
        if(gamePageEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(gamePageMapper.mapFrom(gamePageEntity), HttpStatus.FOUND);
        } 
    }
}
