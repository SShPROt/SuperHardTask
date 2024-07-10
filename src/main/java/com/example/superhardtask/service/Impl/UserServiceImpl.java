package com.example.superhardtask.service.Impl;

import com.example.superhardtask.dto.UserRequestDto;
import com.example.superhardtask.dto.UserResponseDto;
import com.example.superhardtask.entity.User;
import com.example.superhardtask.mapper.UserMapper;
import com.example.superhardtask.repository.UserRepository;
import com.example.superhardtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toEntity(userRequestDto);
        return userMapper.toResponseDto(userRepository.saveAndFlush(user));
    }
}
