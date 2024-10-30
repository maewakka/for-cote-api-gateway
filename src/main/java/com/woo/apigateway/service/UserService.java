package com.woo.apigateway.service;

import com.woo.apigateway.dto.user.UserDto;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.repository.UserAssistCountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAssistCountRepository userAssistCountRepository;

    public UserDto getUserDetail(User user) {
        if(user == null) {
            return null;
        }

        return UserDto.of(user);
    }

    public Long getOptimizeCount(User user) {
        return userAssistCountRepository.findUserAssistCountByUser(user).getCount();
    }

}
