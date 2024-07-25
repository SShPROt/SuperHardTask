package com.example.superhardtask.service;

import com.example.superhardtask.rest.dto.UserRequestDto;
import com.example.superhardtask.rest.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto getUser(String mail);
}
