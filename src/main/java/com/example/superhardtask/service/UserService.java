package com.example.superhardtask.service;

import com.example.superhardtask.dto.UserRequestDto;
import com.example.superhardtask.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUser(String mail);
}
