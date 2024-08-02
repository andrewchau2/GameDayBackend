package com.fightbattle.gameday.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fightbattle.gameday.pojo.dto.GamePageDto;
import com.fightbattle.gameday.pojo.entity.GamePageEntity;

@Component
public class GamePageMapper implements ItemMapper<GamePageEntity,GamePageDto> {

    private ModelMapper modelMapper;

    @Autowired
    public GamePageMapper( ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public GamePageEntity mapTo(GamePageDto gamePageDto) {
        return modelMapper.map(gamePageDto, GamePageEntity.class);
    }

    @Override
    public GamePageDto mapFrom(GamePageEntity gamePageEntity) {
        return modelMapper.map(gamePageEntity, GamePageDto.class);
    }
    
}
