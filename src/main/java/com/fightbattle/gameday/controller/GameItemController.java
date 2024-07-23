package com.fightbattle.gameday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.mapper.GameItemMapper;
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameItemService;

@RestController
public class GameItemController {
    
    private GameItemService gameItemService;
    private GameItemMapper modelMapper;


    @Autowired
    public GameItemController(GameItemService gameItemService,  GameItemMapper modelMapper){
        this.gameItemService = gameItemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/games")
    public ResponseEntity<List<GameItemDto>> findGames(){
        List<GameItemEntity> res = gameItemService.findAll();
    
        return new ResponseEntity<>(res.stream().map(modelMapper::mapFrom).toList(), HttpStatus.FOUND);
    }


    @PostMapping(path = "/games")
    public ResponseEntity<GameItemDto> createGame(@RequestBody GameItemDto gameItemDto){
        GameItemEntity gameItemEntity = modelMapper.mapTo(gameItemDto);
        GameItemEntity created = gameItemService.create(gameItemEntity);
        return new ResponseEntity<>(modelMapper.mapFrom(created), HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/games/{id}")
    public ResponseEntity deleteGame(@PathVariable("id") Long id){
        gameItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/games/{id}")
    public ResponseEntity<GameItemDto> findGame(@PathVariable("id") Long id){
        GameItemEntity gameItemEntity = gameItemService.find(id);
        GameItemDto result = modelMapper.mapFrom(gameItemEntity);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }
}

