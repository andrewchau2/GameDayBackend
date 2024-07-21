package com.fightbattle.gameday.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<GameItemDto> findGames(){
        List<GameItemEntity> res = gameItemService.findAll();
    
        return res.stream().map(modelMapper::mapFrom).toList();
    }
}
