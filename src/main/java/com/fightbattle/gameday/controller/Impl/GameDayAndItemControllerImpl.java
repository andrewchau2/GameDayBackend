package com.fightbattle.gameday.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fightbattle.gameday.controller.GameDayAndItemController;
import com.fightbattle.gameday.mapper.GameDayMapper;
import com.fightbattle.gameday.mapper.GameItemMapper;
import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.service.GameItemService;

public class GameDayAndItemControllerImpl implements GameDayAndItemController {
    private GameDayService gameDayTrackerService;
    private GameDayMapper gameDayTrackerMapper;
    private GameItemMapper gameItemMapper;
    private GameItemService gameItemService;

    @Autowired
    public GameDayAndItemControllerImpl(
        GameDayService gameDayTrackerService,
        GameDayMapper gameDayTrackerMapper, 
        GameItemService gameItemService,
        GameItemMapper gameItemMapper)
    {
        this.gameDayTrackerMapper = gameDayTrackerMapper;
        this.gameDayTrackerService = gameDayTrackerService;
        this.gameItemService = gameItemService;
        this.gameItemMapper = gameItemMapper;
    }

    
    @PutMapping(path="/gamedays/{gameday_id}/games/")
    public GameItemDto addRecentlyPlayedItem(@PathVariable(name="gameday_id") Long gameday_id, @RequestBody GameItemDto gameItemDto)
    {
        return null;
    }

}
