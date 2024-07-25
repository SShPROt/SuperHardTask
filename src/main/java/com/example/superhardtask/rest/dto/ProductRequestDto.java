package com.example.superhardtask.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDto(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull
        int price
) {
}
