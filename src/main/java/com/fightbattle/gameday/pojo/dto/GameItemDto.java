package com.fightbattle.gameday.pojo.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class GameItemDto {
    private Long id;

    private String name;

    private String genre;

    private String lastPlayed;

    private List<String> storePage; 
}

