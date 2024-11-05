package com.woo.apigateway.repository;

import com.woo.apigateway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Boolean existsUserById(String id);
    User findUserById(String id);
}
