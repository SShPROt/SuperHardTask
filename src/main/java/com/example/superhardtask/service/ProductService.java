package com.example.superhardtask.service;

import com.example.superhardtask.dto.ProductRequestDto;
import com.example.superhardtask.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto getProduct(String mail);
}
