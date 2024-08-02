package com.fightbattle.gameday.controller.Impl;

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

import com.fightbattle.gameday.controller.DefaultController;
import com.fightbattle.gameday.mapper.GamePageMapper;
import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.service.GamePageService;
@RestController
public class GamePageController implements DefaultController<GamePageDto>{

    private GamePageService gamePageService;
    private GamePageMapper gamePageMapper;

    @Autowired
    public GamePageController(GamePageService gamePageService, GamePageMapper gamePageMapper){
        this.gamePageService = gamePageService;
        this.gamePageMapper = gamePageMapper;
    }


    @Override
    @GetMapping(path="/gamepages")
    public ResponseEntity<List<GamePageDto>> findGames() {
        List<GamePageDto> res = gamePageService.findAll().stream().map(gamePageMapper::mapFrom).toList();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    @PostMapping(path="/gamepages")
    public ResponseEntity<GamePageDto> createGame(@RequestBody GamePageDto gamePageDto) {
        System.out.println("Here");
        System.out.println(gamePageDto.toString());
        GamePageEntity res = gamePageMapper.mapTo(gamePageDto);
        GamePageDto created = gamePageMapper.mapFrom(gamePageService.create(res));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @SuppressWarnings("rawtypes")
    @Override
    @DeleteMapping(path="/gamepages/{id}")
    public ResponseEntity deleteGame(@PathVariable Long id) {

        gamePageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @GetMapping(path="/gamepages/{id}")
    public ResponseEntity<GamePageDto> findGame(@PathVariable Long id) {
        GamePageEntity gamePageEntity = gamePageService.find(id);
 
        if(gamePageEntity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(gamePageMapper.mapFrom(gamePageEntity), HttpStatus.FOUND);
        } 
    }    
}
