package com.fightbattle.gameday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fightbattle.gameday.pojo.entity.GamePageEntity;

@Repository
public interface GamePageRepository extends JpaRepository<GamePageEntity, Long> {
    
}
