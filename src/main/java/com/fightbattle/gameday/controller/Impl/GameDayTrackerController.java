package com.fightbattle.gameday.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.DefaultController;
import com.fightbattle.gameday.mapper.GameDayTrackerMapper;
import com.fightbattle.gameday.pojo.dto.GameDayTrackerDto;
import com.fightbattle.gameday.pojo.entity.GameDayTrackerEntity;
import com.fightbattle.gameday.service.GameDayTrackerService;

@RestController
public class GameDayTrackerController implements DefaultController<GameDayTrackerDto> {

    private GameDayTrackerService gameDayTrackerService;
    private GameDayTrackerMapper gameDayTrackerMapper;

    @Autowired
    public GameDayTrackerController(GameDayTrackerService gameDayTrackerService,GameDayTrackerMapper gameDayTrackerMapper){
        this.gameDayTrackerMapper = gameDayTrackerMapper;
        this.gameDayTrackerService = gameDayTrackerService;
    }


    @Override
    @GetMapping(path="/gamedays")
    public ResponseEntity<List<GameDayTrackerDto>> findGames() {

        List<GameDayTrackerEntity> res = gameDayTrackerService.findAll();

        return new ResponseEntity<>(res.stream().map(gameDayTrackerMapper::mapFrom).toList(), HttpStatus.FOUND);
    }

    @Override
    @PostMapping(path="/gamedays")
    public ResponseEntity<GameDayTrackerDto> createGame(GameDayTrackerDto gameDayTrackerDto) {
        GameDayTrackerEntity convert = gameDayTrackerMapper.mapTo(gameDayTrackerDto);
        GameDayTrackerEntity res = gameDayTrackerService.create(convert);
        return new ResponseEntity<>(gameDayTrackerMapper.mapFrom(res), HttpStatus.CREATED);
    }

    
    @SuppressWarnings("rawtypes")
    @Override
    public ResponseEntity deleteGame(Long id) {
        gameDayTrackerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<GameDayTrackerDto> findGame(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findGame'");
    }
    
}
