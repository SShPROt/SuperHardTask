package com.example.superhardtask.rest;

import com.example.superhardtask.rest.dto.UserRequestDto;
import com.example.superhardtask.rest.dto.UserResponseDto;
import com.example.superhardtask.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/user")
@Validated
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать нового пользователя", description = "Создание пользователя в системе")
    public UserResponseDto createUser(
            @Validated @RequestBody @Parameter(description = "Данные пользователя")
            UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить данные пользователя", description = "Получение данных по почте")
    public UserResponseDto getUser(
            @Parameter(description = "Почта пользователя", required = true) @RequestParam String mail) {
        return userService.getUser(mail);
    }
}
