package com.fightbattle.gameday.pojo.dto;

import java.sql.Date;
import java.util.List;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GameDayTrackerDto {
    public Long id;

    public String temp;
    
    public Date date;

    public List<GameItemEntity> recentlyPlayed;
}
