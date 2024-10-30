package com.woo.apigateway.repository;

import com.woo.apigateway.entity.User;
import com.woo.apigateway.entity.UserAssistCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAssistCountRepository extends JpaRepository<UserAssistCount, Long> {
    UserAssistCount findUserAssistCountByUser(User user);
}
