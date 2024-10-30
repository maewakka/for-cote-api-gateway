package com.woo.apigateway.controller;

import com.woo.apigateway.dto.user.UserDto;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.oauth.CurrentUser;
import com.woo.apigateway.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user-detail")
    public UserDto getUserDetail(@CurrentUser User user) {
        return userService.getUserDetail(user);
    }

    @GetMapping("/optimize-count")
    public Long getOptimizeCount(@CurrentUser User user) {
        return userService.getOptimizeCount(user);
    }

}
