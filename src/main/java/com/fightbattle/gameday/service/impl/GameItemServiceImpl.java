package com.fightbattle.gameday.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;
import com.fightbattle.gameday.repository.GameItemRepository;
import com.fightbattle.gameday.service.GameItemService;

@Service
public class GameItemServiceImpl implements GameItemService {

    @Autowired
    public GameItemRepository gameItemRepository;

    @Override
    public GameItemEntity find(Long id) {
        Optional<GameItemEntity> res = gameItemRepository.findById(id);
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public void delete(Long id) {
        gameItemRepository.deleteById(id);
    }

    @Override
    public GameItemEntity fullUpdate(GameItemEntity gameItem) {
        return create(gameItem);
    }

    @Override
    public GameItemEntity create(GameItemEntity gameItem) {
        if(gameItem == null){
            return null;
        }
        gameItem.setName(gameItem.getName().toLowerCase());
        return gameItemRepository.save(gameItem);
    }


    @Override
    public List<GameItemEntity> findAll() {
        return gameItemRepository.findAll();
    }

    @Override
    public GameItemEntity findByName(String name){
        Iterable<GameItemEntity> res = gameItemRepository.findGameByName(name);
        if(res.iterator().hasNext() == false){
            return null;
        }
        return res.iterator().next();
    }
    
}
