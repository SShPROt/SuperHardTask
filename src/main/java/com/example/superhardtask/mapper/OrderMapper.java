package com.example.superhardtask.mapper;

import com.example.superhardtask.entity.Order;
import com.example.superhardtask.entity.ProductOrder;
import com.example.superhardtask.rest.dto.OrderResponseDto;
import com.example.superhardtask.rest.dto.ProductOrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderResponseDto toResponseDto(Order order, List<ProductOrderResponseDto> productOrderResponseDto);

    @Mapping(target = "id", source = "productOrder.product.id")
    @Mapping(target = "name", source = "productOrder.product.name")
    @Mapping(target = "price", source = "productOrder.product.price")
    ProductOrderResponseDto toProductOrderResponseDto(ProductOrder productOrder);
}
