package com.example.superhardtask.mapper;

import com.example.superhardtask.dto.ProductRequestDto;
import com.example.superhardtask.dto.ProductResponseDto;
import com.example.superhardtask.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    Product toEntity(ProductRequestDto productRequestDto);
    ProductResponseDto toDto(Product product);
}
