package com.fightbattle.gameday.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.GameItemController;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameItemService;

@RestController
public class GameItemCtrlImpl implements GameItemController{
    
    private GameItemService gameItemService;


    @Autowired
    public GameItemCtrlImpl(GameItemService gameItemService){
        this.gameItemService = gameItemService;
    }

    @GetMapping(path = "/games")
    public ResponseEntity<List<GameItemEntity>> getAll(){
        List<GameItemEntity> res = gameItemService.findAll();
    
        return new ResponseEntity<>(res.stream().toList(), HttpStatus.FOUND);
    }

    @PutMapping(path = "/games")
    public ResponseEntity<GameItemEntity> create(@RequestBody GameItemEntity gameItemEntity){
        GameItemEntity created = gameItemService.create(gameItemEntity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping(path = "/games/{id}")
    public ResponseEntity<GameItemEntity> update(@RequestBody GameItemEntity gameItemEntity, @PathVariable(name="id") Long id){
        if(gameItemService.find(id) == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        GameItemEntity updated = gameItemService.fullUpdate(gameItemEntity);
        return new ResponseEntity<>(updated, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/games/{id}")
    public ResponseEntity<GameItemEntity> delete(@PathVariable("id") Long id){
        gameItemService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/games/{id}")
    public ResponseEntity<GameItemEntity> getById(@PathVariable("id") Long id){
        GameItemEntity gameItemEntity = gameItemService.find(id);
        System.out.println(gameItemEntity);
        if(gameItemEntity == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gameItemEntity, HttpStatus.FOUND);
    }
}

