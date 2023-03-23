package io.productdemo.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
