package com.example.superhardtask.mapper;

import com.example.superhardtask.entity.Product;
import com.example.superhardtask.rest.dto.ProductRequestDto;
import com.example.superhardtask.rest.dto.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    Product toEntity(ProductRequestDto productRequestDto);

    ProductResponseDto toResponseDto(Product product);
}
