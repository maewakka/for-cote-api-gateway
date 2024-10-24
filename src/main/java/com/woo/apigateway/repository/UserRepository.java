package com.woo.apigateway.repository;

import com.woo.apigateway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByEmail(String email);
    User findUserByEmail(String email);
}
