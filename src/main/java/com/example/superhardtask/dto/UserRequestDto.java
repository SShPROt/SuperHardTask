package com.example.superhardtask.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(

        @NotBlank
        String mail,

        @NotBlank
        String name
) {
}