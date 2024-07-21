package com.fightbattle.gameday.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fightbattle.gameday.pojo.dto.GameItemDto;
import com.fightbattle.gameday.pojo.entity.GameItemEntity;

public class GameItemMapper implements ItemMapper<GameItemEntity, GameItemDto> {

    ModelMapper modelMapper;

    @Autowired
    public GameItemMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public GameItemEntity mapTo(GameItemDto gameItemDto) {
        return modelMapper.map(gameItemDto, GameItemEntity.class);
    }

    @Override
    public GameItemDto mapFrom(GameItemEntity gameItemEntity) {
        return modelMapper.map(gameItemEntity, GameItemDto.class);
    }
    
}
