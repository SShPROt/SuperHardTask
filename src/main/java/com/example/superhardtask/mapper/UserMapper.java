package com.example.superhardtask.mapper;

import com.example.superhardtask.dto.UserRequestDto;
import com.example.superhardtask.dto.UserResponseDto;
import com.example.superhardtask.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(User user);
}
