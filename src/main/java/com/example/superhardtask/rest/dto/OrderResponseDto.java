package com.example.superhardtask.rest.dto;

import java.util.List;
import java.util.UUID;

public record OrderResponseDto(
        UUID id,
        int price,
        List<ProductOrderResponseDto> productOrderResponseDto
) {
}
