package io.productdemo.demo.seervices.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import io.productdemo.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
