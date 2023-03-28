package io.productdemo.demo.services.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}