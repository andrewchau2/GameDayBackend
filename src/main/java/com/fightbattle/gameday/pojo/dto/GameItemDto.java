package com.fightbattle.gameday.pojo.dto;

import java.util.List;

import com.fightbattle.gameday.pojo.entity.GamePageEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GameItemDto {
    private Long id;

    private String name;

    private String genre;

    private String lastPlayed;

    private GamePageEntity gamePage;
}

