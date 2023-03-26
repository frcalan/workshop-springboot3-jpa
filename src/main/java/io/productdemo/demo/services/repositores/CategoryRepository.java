package io.productdemo.demo.services.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
