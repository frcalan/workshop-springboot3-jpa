package io.productdemo.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
