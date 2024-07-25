package com.example.superhardtask.rest.dto;

import java.util.UUID;

public record ProductOrderResponseDto(
        UUID id,
        String name,
        int price,
        int number
) {
}
