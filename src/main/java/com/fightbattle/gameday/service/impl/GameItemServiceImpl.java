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

    public GameItemRepository gameItemRepository;

    @Autowired
    public GameItemServiceImpl(GameItemRepository gameItemRepository){
        this.gameItemRepository = gameItemRepository;
    }


    @Override
    public GameItemEntity find(Long id) {
        Optional<GameItemEntity> res = gameItemRepository.findById(id);
        return res.isPresent() ? res.get() : null;
    }

    @Override
    public void delete(Long id) {
        gameItemRepository.deleteById(id);
    }


    private boolean verifyIdSwap(Long currentId, Long newId){
        boolean currentIdFound = gameItemRepository.findById(currentId).isPresent();
        boolean newIdFound = gameItemRepository.findById(newId).isPresent();

        if(currentIdFound == true && newIdFound == false){
            return true;
        }
        return false;
    }

    @Override
    public GameItemEntity partialUpdate(Long id, GameItemEntity gameItem) {
        boolean validOperation = verifyIdSwap(gameItem.getId(), id);
        if(validOperation == false){
            return null;
        }

        gameItem.setId(id);
        return gameItemRepository.save(gameItem);
    }

    @Override
    public GameItemEntity fullUpdate(GameItemEntity gameItem) {
        return gameItemRepository.save(gameItem);
    }

    @Override
    public GameItemEntity create(GameItemEntity gameItemEntity) {
        return gameItemRepository.save(gameItemEntity);
    }


    @Override
    public List<GameItemEntity> findAll() {
        return gameItemRepository.findAll();
    }
    
}
