package com.woo.apigateway.dto.oauth;

import com.woo.apigateway.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class GithubOAuthAttributeDto {

    private String email;
    private String name;
    private String profileImgUrl;
    private String repoUrl;

    public static GithubOAuthAttributeDto of(Map<String, Object> attributes) {
        return GithubOAuthAttributeDto.builder()
                .email(attributes.get("email").toString())
                .name(attributes.get("name").toString())
                .profileImgUrl(attributes.get("avatar_url").toString())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .profileImgUrl(profileImgUrl)
                .build();
    }


}
