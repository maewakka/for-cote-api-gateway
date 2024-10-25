package com.woo.apigateway.dto.user;

import com.woo.apigateway.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String email;
    private String profileImgUrl;

    public static UserDto of(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .profileImgUrl(user.getProfileImgUrl())
                .build();
    }

}
