package com.fightbattle.gameday.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fightbattle.gameday.pojo.dto.GameDayDto;
import com.fightbattle.gameday.pojo.entity.GameDayEntity;

@Component
public class GameDayMapper implements ItemMapper<GameDayEntity, GameDayDto> {

    private ModelMapper modelMapper;

    @Autowired
    public GameDayMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public GameDayEntity mapTo(GameDayDto gameDayTrackerDto) {
        return modelMapper.map(gameDayTrackerDto, GameDayEntity.class);
    }

    @Override
    public GameDayDto mapFrom(GameDayEntity gameDayTrackerEntity) {
        return modelMapper.map(gameDayTrackerEntity, GameDayDto.class);
    }
    
}
