package com.example.superhardtask.rest.dto;

import com.example.superhardtask.entity.ProductsAndNum;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderRequestDto(
        @NotNull
        UUID userId,

        @NotNull
        List<ProductsAndNum> productOrderList
) {
}
