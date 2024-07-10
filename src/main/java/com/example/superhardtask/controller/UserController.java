package com.example.superhardtask.controller;

import com.example.superhardtask.dto.UserRequestDto;
import com.example.superhardtask.dto.UserResponseDto;
import com.example.superhardtask.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новую задачу", description = "Создать новую задачу с указанными деталями")
    public UserResponseDto createTask(
            @Validated @RequestBody @Parameter(description = "Детали задачи для создания")
            UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

}
