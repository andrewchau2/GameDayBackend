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

import com.fightbattle.gameday.controller.GameDayController;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.service.GameDayService;

@RestController
public class GameDayControllerImpl implements GameDayController{

    private GameDayService gameDayTrackerService;

    @Autowired
    public GameDayControllerImpl(GameDayService gameDayTrackerService){
        this.gameDayTrackerService = gameDayTrackerService;
    }


    @GetMapping(path="/gamedays")
    public ResponseEntity<List<GameDayEntity>> getAll() {

        List<GameDayEntity> res = gameDayTrackerService.findAll();

        return new ResponseEntity<>(res.stream().toList(), HttpStatus.FOUND);
    }

    public ResponseEntity<GameDayEntity> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findGame'");
    }

    @PutMapping(path="/gamedays")
    public ResponseEntity<GameDayEntity> create(@RequestBody GameDayEntity gameDayTracker) {
        GameDayEntity res = gameDayTrackerService.create(gameDayTracker);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    
    @SuppressWarnings("rawtypes")
    @DeleteMapping(path="/gamedays/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        gameDayTrackerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
