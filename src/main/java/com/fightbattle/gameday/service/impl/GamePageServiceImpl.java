package com.fightbattle.gameday.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbattle.gameday.pojo.entity.GamePageEntity;
import com.fightbattle.gameday.repository.GamePageRepository;
import com.fightbattle.gameday.service.GamePageService;

@Service
public class GamePageServiceImpl implements GamePageService{

    @Autowired
    private GamePageRepository gamePageRepository;

    @Override
    public GamePageEntity find(Long id) {
        Optional<GamePageEntity> res = gamePageRepository.findById(id);
        return res.isPresent() ? res.get() : null;
    }


    @Override
    public List<GamePageEntity> findAll() {
        return gamePageRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        gamePageRepository.deleteById(id);
    }

    @Override
    public GamePageEntity fullUpdate(GamePageEntity gamePageEntity) {
        return gamePageRepository.save(gamePageEntity);
    }


    @Override
    public GamePageEntity create(GamePageEntity gamePageEntity) {
        return gamePageRepository.save(gamePageEntity);
    }


    
}
