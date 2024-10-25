package com.woo.apigateway.service;

import com.woo.apigateway.dto.user.UserDto;
import com.woo.apigateway.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    public UserDto getUserDetail(User user) {
        if(user == null) {
            return null;
        }

        return UserDto.of(user);
    }

}
