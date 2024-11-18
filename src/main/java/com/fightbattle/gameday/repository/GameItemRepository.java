package com.fightbattle.gameday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

@Repository
public interface GameItemRepository extends JpaRepository<GameItemEntity, Long>{

    @Query("SELECT a from GameItemEntity a where a.name = ?1")
    Iterable<GameItemEntity> findGameByName(String name);
}
