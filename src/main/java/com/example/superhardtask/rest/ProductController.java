package com.example.superhardtask.rest;

import com.example.superhardtask.rest.dto.ProductRequestDto;
import com.example.superhardtask.rest.dto.ProductResponseDto;
import com.example.superhardtask.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новый товар", description = "Создание товара в системе")
    public ProductResponseDto createProduct(
            @Validated @RequestBody @Parameter(description = "Данные о товаре")
            ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить данные товара", description = "Получение данных по названию")
    public ProductResponseDto getProduct(
            @Parameter(description = "Название товара", required = true) @RequestParam String name) {
        return productService.getProduct(name);
    }
}
