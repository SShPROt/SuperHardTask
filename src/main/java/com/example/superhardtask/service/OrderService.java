package com.example.superhardtask.service;

import com.example.superhardtask.rest.dto.OrderRequestDto;
import com.example.superhardtask.rest.dto.OrderResponseAllDto;
import com.example.superhardtask.rest.dto.OrderResponseDto;

import java.util.UUID;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    OrderResponseAllDto getOrder(UUID userId);
}
