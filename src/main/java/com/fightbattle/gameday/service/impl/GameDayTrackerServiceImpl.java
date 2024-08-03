package com.fightbattle.gameday.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbattle.gameday.pojo.entity.GameDayTrackerEntity;
import com.fightbattle.gameday.repository.GameDayTrackerRepository;
import com.fightbattle.gameday.service.GameDayTrackerService;

@Service
public class GameDayTrackerServiceImpl implements GameDayTrackerService{

    private GameDayTrackerRepository gameDayTrackerRepository;

    @Autowired
    public GameDayTrackerServiceImpl(GameDayTrackerRepository gameDayTrackerRepository){
        this.gameDayTrackerRepository = gameDayTrackerRepository;
    }


    @Override
    public GameDayTrackerEntity find(Long id) {
        Optional<GameDayTrackerEntity> res = gameDayTrackerRepository.findById(id);
        
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public List<GameDayTrackerEntity> findAll() {
        return gameDayTrackerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        gameDayTrackerRepository.deleteById(id);
    }

    @Override
    public GameDayTrackerEntity partialUpdate(Long id, GameDayTrackerEntity gameDayTrackerEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

    @Override
    public GameDayTrackerEntity fullUpdate(GameDayTrackerEntity gameDayTrackerEntity) {
        return gameDayTrackerRepository.save(gameDayTrackerEntity);
    }

    @Override
    public GameDayTrackerEntity create(GameDayTrackerEntity gameDayTrackerEntity) {
        return gameDayTrackerRepository.save(gameDayTrackerEntity);
    }
    
}
