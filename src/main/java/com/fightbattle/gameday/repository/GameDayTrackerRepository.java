package com.fightbattle.gameday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fightbattle.gameday.pojo.entity.GameDayTrackerEntity;

@Repository
public interface GameDayTrackerRepository extends JpaRepository<GameDayTrackerEntity, Long> {
    
}
