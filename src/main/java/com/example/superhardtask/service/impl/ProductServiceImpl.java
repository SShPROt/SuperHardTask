package com.example.superhardtask.service.impl;

import com.example.superhardtask.entity.Product;
import com.example.superhardtask.mapper.ProductMapper;
import com.example.superhardtask.repository.ProductRepository;
import com.example.superhardtask.rest.dto.ProductRequestDto;
import com.example.superhardtask.rest.dto.ProductResponseDto;
import com.example.superhardtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toEntity(productRequestDto);
        return productMapper.toResponseDto(productRepository.saveAndFlush(product));
    }

    @Override
    public ProductResponseDto getProduct(String mail) {
        return productMapper.toResponseDto(productRepository.findByName(mail));
    }
}
