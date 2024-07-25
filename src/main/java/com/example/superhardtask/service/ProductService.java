package com.example.superhardtask.service;

import com.example.superhardtask.rest.dto.ProductRequestDto;
import com.example.superhardtask.rest.dto.ProductResponseDto;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto userRequestDto);

    ProductResponseDto getProduct(String mail);
}
