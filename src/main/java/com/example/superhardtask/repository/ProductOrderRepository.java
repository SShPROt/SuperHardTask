package com.example.superhardtask.repository;

import com.example.superhardtask.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, UUID> {

    List<ProductOrder> findAllProductOrderByOrderId(UUID orderId);
}
