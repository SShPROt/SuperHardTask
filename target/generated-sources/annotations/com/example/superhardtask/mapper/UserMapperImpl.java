package com.example.superhardtask.mapper;

import com.example.superhardtask.dto.UserRequestDto;
import com.example.superhardtask.dto.UserResponseDto;
import com.example.superhardtask.entity.User;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T11:58:30+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    @Override
    public UserResponseDto toResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UUID id = null;

        UserResponseDto userResponseDto = new UserResponseDto( id );

        return userResponseDto;
    }
}
