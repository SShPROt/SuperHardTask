package com.example.superhardtask.rest;

import com.example.superhardtask.rest.dto.OrderRequestDto;
import com.example.superhardtask.rest.dto.OrderResponseAllDto;
import com.example.superhardtask.rest.dto.OrderResponseDto;
import com.example.superhardtask.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Validated
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новый заказ", description = "Создание заказа в системе")
    public OrderResponseDto createOrder(
            @Validated @RequestBody @Parameter(description = "Данные о заказе")
            OrderRequestDto orderRequestDto) {
        return orderService.createOrder(orderRequestDto);
    }

    @GetMapping("/order")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить все заказы пользователя", description = "Получение данных по id пользователя")
    public OrderResponseAllDto getOrder(
            @Parameter(description = "Название товара", required = true) @RequestParam UUID userId) {
        return orderService.getOrder(userId);
    }
}
