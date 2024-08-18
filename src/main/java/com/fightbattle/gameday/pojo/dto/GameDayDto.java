package com.fightbattle.gameday.pojo.dto;

import java.util.List;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GameDayDto {
    private Long id;

    private String serverName;

    private String description;

    private String nextGameDay;

    private List<GameItemEntity> recentlyPlayed;
}
