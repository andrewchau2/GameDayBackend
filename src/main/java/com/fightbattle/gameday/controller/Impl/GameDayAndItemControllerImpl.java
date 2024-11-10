package com.fightbattle.gameday.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fightbattle.gameday.controller.GameDayAndItemController;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.service.GameItemService;

public class GameDayAndItemControllerImpl implements GameDayAndItemController {
    private GameDayService gameDayTrackerService;
    private GameItemService gameItemService;

    @Autowired
    public GameDayAndItemControllerImpl(
        GameDayService gameDayTrackerService,
        GameItemService gameItemService)
    {
        this.gameDayTrackerService = gameDayTrackerService;
        this.gameItemService = gameItemService;
    }

    
    @PutMapping(path="/gamedays/{gameday_id}/games/")
    public GameItemEntity addRecentlyPlayedItem(@PathVariable(name="gameday_id") Long gameday_id, @RequestBody GameItemEntity gameItemEntity)
    {
        return null;
    }

}
