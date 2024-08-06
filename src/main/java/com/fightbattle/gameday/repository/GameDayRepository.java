package com.fightbattle.gameday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fightbattle.gameday.pojo.entity.GameDayEntity;

@Repository
public interface GameDayRepository extends JpaRepository<GameDayEntity, Long> {
    
}
