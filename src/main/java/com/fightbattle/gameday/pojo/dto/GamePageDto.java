package com.fightbattle.gameday.pojo.dto;

import com.fightbattle.gameday.pojo.entity.GameItemEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GamePageDto {
    private Long id;

    private GameItemEntity gameItemEntity;

    private String steamLink;

    private String g2aLink;

    private String cdKeyLink;
}
