package io.productdemo.demo.repositores;

import io.productdemo.demo.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
