package com.example.superhardtask.rest.dto;

import java.util.List;

public record OrderResponseAllDto(
        //AllOrders allOrders
        List<OrderResponseDto> orderList
) {
}
