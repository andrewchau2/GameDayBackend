package com.fightbattle.gameday.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.repository.GameDayRepository;
import com.fightbattle.gameday.repository.GameItemRepository;
import com.fightbattle.gameday.service.GameDayService;

@Service
public class GameDayServiceImpl implements GameDayService{

    @Autowired
    private GameDayRepository gameDayRepo;

    @Autowired
    private GameItemRepository gameItemRepo;


    @Override
    public GameDayEntity find(Long id) {
        Optional<GameDayEntity> res = gameDayRepo.findById(id);
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public List<GameDayEntity> findAll() {
        return gameDayRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        gameDayRepo.deleteById(id);
    }
    
    @Override
    public GameDayEntity fullUpdate(GameDayEntity gameDayEntity) {
        return create(gameDayEntity);
    }

    @Override
    public GameDayEntity create(GameDayEntity gameDayEntity) {
        if(gameDayEntity == null)
            return null;
        return gameDayRepo.save(gameDayEntity);
    } 
}
