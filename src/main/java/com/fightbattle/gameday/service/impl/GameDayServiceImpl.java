package com.fightbattle.gameday.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;
import com.fightbattle.gameday.repository.GameDayRepository;
import com.fightbattle.gameday.service.GameDayService;

@Service
public class GameDayServiceImpl implements GameDayService{

    private GameDayRepository gameDayTrackerRepository;

    @Autowired
    public GameDayServiceImpl(GameDayRepository gameDayTrackerRepository){
        this.gameDayTrackerRepository = gameDayTrackerRepository;
    }


    @Override
    public GameDayEntity find(Long id) {
        Optional<GameDayEntity> res = gameDayTrackerRepository.findById(id);
        
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public List<GameDayEntity> findAll() {
        return gameDayTrackerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        gameDayTrackerRepository.deleteById(id);
    }

    @Override
    public GameDayEntity partialUpdate(Long id, GameDayEntity gameDayTrackerEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'partialUpdate'");
    }

    @Override
    public GameDayEntity fullUpdate(GameDayEntity gameDayTrackerEntity) {
        return gameDayTrackerRepository.save(gameDayTrackerEntity);
    }

    @Override
    public GameDayEntity create(GameDayEntity gameDayTrackerEntity) {
        return gameDayTrackerRepository.save(gameDayTrackerEntity);
    }
    
}
