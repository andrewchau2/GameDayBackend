package com.fightbattle.gameday.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fightbattle.gameday.pojo.dto.GameDayTrackerDto;
import com.fightbattle.gameday.pojo.entity.GameDayTrackerEntity;

@Component
public class GameDayTrackerMapper implements ItemMapper<GameDayTrackerEntity, GameDayTrackerDto> {

    private ModelMapper modelMapper;

    @Autowired
    public GameDayTrackerMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public GameDayTrackerEntity mapTo(GameDayTrackerDto gameDayTrackerDto) {
        return modelMapper.map(gameDayTrackerDto, GameDayTrackerEntity.class);
    }

    @Override
    public GameDayTrackerDto mapFrom(GameDayTrackerEntity gameDayTrackerEntity) {
        return modelMapper.map(gameDayTrackerEntity, GameDayTrackerDto.class);
    }
    
}
