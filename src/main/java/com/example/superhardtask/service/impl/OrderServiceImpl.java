package com.example.superhardtask.service.impl;

import com.example.superhardtask.entity.*;
import com.example.superhardtask.mapper.OrderMapper;
import com.example.superhardtask.repository.OrderRepository;
import com.example.superhardtask.repository.ProductOrderRepository;
import com.example.superhardtask.repository.ProductRepository;
import com.example.superhardtask.repository.UserRepository;
import com.example.superhardtask.rest.dto.OrderRequestDto;
import com.example.superhardtask.rest.dto.OrderResponseAllDto;
import com.example.superhardtask.rest.dto.OrderResponseDto;
import com.example.superhardtask.rest.dto.ProductOrderResponseDto;
import com.example.superhardtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;

    private final OrderMapper orderMapper;

    @Transactional
    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        int price = 0;
        List<ProductOrderResponseDto> productOrderDtoList = new ArrayList<>();
        List<ProductOrder> productOrderList = new ArrayList<>();

        UUID userId = orderRequestDto.userId();
        List<ProductsAndNum> productsAndNumsList = orderRequestDto.productOrderList();

        Order order = new Order();
        User user;

        user = userRepository.findById(userId).orElse(null);
        order.setUser(user);


        for (ProductsAndNum productsAndNum : productsAndNumsList) {
            Product product = productRepository.findById(productsAndNum.getProductId()).orElse(null);
            if (product != null) {
                price += product.getPrice() * productsAndNum.getNumber();
            }

            ProductOrder productOrder = new ProductOrder();
            productOrder.setProduct(product);
            productOrder.setNumber(productsAndNum.getNumber());
            productOrder.setOrder(order);
            productOrderList.add(productOrder);
            productOrderDtoList.add(orderMapper.toProductOrderResponseDto(productOrder));
        }
        order.setPrice(price);
        Order savedOrder = orderRepository.saveAndFlush(order);
        productOrderRepository.saveAllAndFlush(productOrderList);

        return orderMapper.toResponseDto(savedOrder, productOrderDtoList);
    }

    @Override
    public OrderResponseAllDto getOrder(UUID userId) {
        List<Order> orderList = orderRepository.findAllOrdersByUserId(userId);
        List<ProductOrder> productOrderList;
        List<ProductOrderResponseDto> productOrderResponseDtoList = new ArrayList<>();
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        for (Order order : orderList) {
            productOrderList = productOrderRepository.findAllProductOrderByOrderId(order.getId());
            for (ProductOrder productOrder : productOrderList) {
                productOrderResponseDtoList.add(orderMapper.toProductOrderResponseDto(productOrder));
            }
            orderResponseDtoList.add(orderMapper.toResponseDto(order, productOrderResponseDtoList));
        }
        return new OrderResponseAllDto(orderResponseDtoList);
    }
}
