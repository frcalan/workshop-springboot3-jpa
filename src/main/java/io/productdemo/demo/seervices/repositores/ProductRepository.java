package io.productdemo.demo.seervices.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
