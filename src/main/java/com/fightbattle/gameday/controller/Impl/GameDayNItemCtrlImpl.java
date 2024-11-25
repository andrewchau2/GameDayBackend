package com.fightbattle.gameday.controller.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fightbattle.gameday.controller.GameDayAndItemController;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.service.GameDayService;
import com.fightbattle.gameday.service.GameItemService;

@RestController
public class GameDayNItemCtrlImpl implements GameDayAndItemController {

    @Autowired
    private GameDayService gameDayService;

    @Autowired
    private GameItemService gameItemService;

    @PutMapping(path="/gamedays/{gameday_id}/games/{gameitem_id}")
    public ResponseEntity<GameItemEntity> addGameDaySetItem(
    @PathVariable(name="gameday_id") Long gameDayID,
    @PathVariable(name="gameitem_id") Long gameItemID,
    @RequestParam String type)
    {  

        GameDayEntity gameDay = gameDayService.find(gameDayID);
        GameItemEntity gameItem = gameItemService.find(gameItemID);
        if(gameDay == null || gameItem == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Set<GameItemEntity> setType = type.equalsIgnoreCase("recentlyplayed") ? gameDay.getRecentlyPlayed() : gameDay.getWishlist();
        setType.add(gameItem);
        gameDayService.fullUpdate(gameDay);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @SuppressWarnings(value = "rawtypes")
    @DeleteMapping(path="/gamedays/{gameday_id}/games/{gameitem_id}")
    public ResponseEntity deleteGameDaySetItem(
        @PathVariable(name="gameday_id") Long gameDayID,
        @PathVariable(name="gameitem_id") Long gameItemID,
        @RequestParam String type
    ){
        GameDayEntity gameDay = gameDayService.find(gameDayID);
        GameItemEntity gameItem = gameItemService.find(gameItemID);
        
        if(gameDay == null || gameItem == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    
        
        Set<GameItemEntity> setType = type.equalsIgnoreCase("recentlyplayed") ? gameDay.getRecentlyPlayed() : gameDay.getWishlist();
        setType.remove(gameItem);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(path="/gamedays/{gameday_id}/games/{gameitem_id}")
    public ResponseEntity<Set<GameItemEntity>> getGameDaySetItem(
        @PathVariable(name="gameday_id") Long gameDayID,
        @PathVariable(name="gameitem_id") Long gameItemID,
        @RequestParam(name="type") String type
    ){
        GameDayEntity gameDay = gameDayService.find(gameDayID);
        GameItemEntity gameItem = gameItemService.find(gameItemID);
        
        if(gameDay == null || gameItem == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    

        Set<GameItemEntity> setType = type.equalsIgnoreCase("recentlyplayed") ? gameDay.getRecentlyPlayed() : gameDay.getWishlist();
        
        return new ResponseEntity<>(setType,HttpStatus.FOUND);
    }
}
