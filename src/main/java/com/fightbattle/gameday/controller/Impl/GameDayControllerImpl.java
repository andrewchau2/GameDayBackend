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
import com.fightbattle.gameday.mapper.GameDayMapper;
import com.fightbattle.gameday.pojo.dto.GameDayDto;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.service.GameDayService;

@RestController
public class GameDayControllerImpl implements GameDayController{

    private GameDayService gameDayTrackerService;
    private GameDayMapper gameDayTrackerMapper;

    @Autowired
    public GameDayControllerImpl(GameDayService gameDayTrackerService,GameDayMapper gameDayTrackerMapper){
        this.gameDayTrackerMapper = gameDayTrackerMapper;
        this.gameDayTrackerService = gameDayTrackerService;
    }


    @GetMapping(path="/gamedays")
    public ResponseEntity<List<GameDayDto>> getAll() {

        List<GameDayEntity> res = gameDayTrackerService.findAll();

        return new ResponseEntity<>(res.stream().map(gameDayTrackerMapper::mapFrom).toList(), HttpStatus.FOUND);
    }

    public ResponseEntity<GameDayDto> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findGame'");
    }

    @PutMapping(path="/gamedays")
    public ResponseEntity<GameDayDto> create(@RequestBody GameDayDto gameDayTrackerDto) {
        GameDayEntity convert = gameDayTrackerMapper.mapTo(gameDayTrackerDto);
        GameDayEntity res = gameDayTrackerService.create(convert);
        return new ResponseEntity<>(gameDayTrackerMapper.mapFrom(res), HttpStatus.CREATED);
    }

    
    @SuppressWarnings("rawtypes")
    @DeleteMapping(path="/gamedays/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        gameDayTrackerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
