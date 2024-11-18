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

import com.fightbattle.gameday.controller.GameDayController;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.service.GameDayService;

@RestController
public class GameDayControllerImpl implements GameDayController{

    @Autowired
    private GameDayService gameDayService;

    @GetMapping(path="/gamedays")
    public ResponseEntity<List<GameDayEntity>> getAll() {

        List<GameDayEntity> res = gameDayService.findAll();
        return new ResponseEntity<>(res.stream().toList(), HttpStatus.FOUND);
    }

    @GetMapping(path="/gamedays/{id}")
    public ResponseEntity<GameDayEntity> getById(@PathVariable(name="id") Long id) {
        GameDayEntity res = gameDayService.find(id);
        return res == null ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    @PutMapping(path="/gamedays")
    public ResponseEntity<GameDayEntity> create(@RequestBody GameDayEntity gameDayTracker) {
        GameDayEntity res = gameDayService.create(gameDayTracker);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping(path="/gamedays/{id}")
    public ResponseEntity<GameDayEntity> fullUpdate(@RequestBody GameDayEntity newGameDay, @PathVariable(name="id") Long id){
        if(gameDayService.find(id) == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        GameDayEntity updated = gameDayService.fullUpdate(newGameDay);
        return new ResponseEntity<>(updated, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path="/gamedays/{id}")
    public ResponseEntity<GameDayEntity> delete(@PathVariable(name="id") Long id) {
        gameDayService.delete(id);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
    
}
