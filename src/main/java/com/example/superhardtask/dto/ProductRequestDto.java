package com.example.superhardtask.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductRequestDto(
        @NotBlank
        String name,

        @NotBlank
        String description
) {
}
