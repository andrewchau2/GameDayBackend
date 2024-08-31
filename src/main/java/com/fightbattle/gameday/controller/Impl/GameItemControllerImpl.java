package com.fightbattle.gameday.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.GameItemController;
import com.fightbattle.gameday.mapper.GameItemMapper;
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameItemService;

@RestController
public class GameItemControllerImpl implements GameItemController{
    
    private GameItemService gameItemService;
    private GameItemMapper modelMapper;


    @Autowired
    public GameItemControllerImpl(GameItemService gameItemService,  GameItemMapper modelMapper){
        this.gameItemService = gameItemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/games")
    public ResponseEntity<List<GameItemDto>> getAll(){
        List<GameItemEntity> res = gameItemService.findAll();
    
        return new ResponseEntity<>(res.stream().map(modelMapper::mapFrom).toList(), HttpStatus.FOUND);
    }

    @PutMapping(path = "/games")
    public ResponseEntity<GameItemDto> create(@RequestBody GameItemDto gameItemDto){
        GameItemEntity gameItemEntity = modelMapper.mapTo(gameItemDto);
        GameItemEntity created = gameItemService.create(gameItemEntity);
        return new ResponseEntity<>(modelMapper.mapFrom(created), HttpStatus.CREATED);
    }


    @SuppressWarnings("rawtypes")
    @DeleteMapping(path = "/games/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        gameItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/games/{id}")
    public ResponseEntity<GameItemDto> getById(@PathVariable("id") Long id){
        GameItemEntity gameItemEntity = gameItemService.find(id);
        
        if(gameItemEntity == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        GameItemDto result = modelMapper.mapFrom(gameItemEntity);
        return new ResponseEntity<>(result, HttpStatus.FOUND);
    }

}

