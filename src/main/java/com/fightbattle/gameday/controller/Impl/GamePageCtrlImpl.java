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

import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GamePageService;


@RestController
public class GamePageCtrlImpl {
    @Autowired
    private GamePageService gamePageService;

    @GetMapping(path="/gamepages")
    public ResponseEntity<List<GamePageEntity>> getAll() {
        List<GamePageEntity> res = gamePageService.findAll().stream().toList();
        return new ResponseEntity<>(res, HttpStatus.FOUND);
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

    @PutMapping(path="/gamepages")
    public ResponseEntity<GamePageEntity> create(@RequestBody GamePageEntity gamePage){
        GamePageEntity created =  gamePageService.create(gamePage);
        if(created == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @PostMapping(path="/gamepages/{id}")
    public ResponseEntity<GamePageEntity> update(@RequestBody GamePageEntity gamePage, Long id){
        if(gamePageService.find(id) == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        GamePageEntity saved = gamePageService.fullUpdate(gamePage);
        return new ResponseEntity<>(saved, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(path="/gamepages/{id}")
    public ResponseEntity<GamePageEntity> delete(@PathVariable(name="id") Long id){
        gamePageService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
