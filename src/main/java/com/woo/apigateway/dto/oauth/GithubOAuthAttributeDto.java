package com.woo.apigateway.dto.oauth;

import com.woo.apigateway.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Data
@Slf4j
@Builder
public class GithubOAuthAttributeDto {

    private String id;
    private String login;
    private String name;
    private String profileImgUrl;
    private String repoUrl;

    public static GithubOAuthAttributeDto of(Map<String, Object> attributes) {
        return GithubOAuthAttributeDto.builder()
                .id(attributes.get("id").toString())
                .login(attributes.get("login").toString())
                .name(attributes.get("name").toString())
                .profileImgUrl(attributes.get("avatar_url").toString())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .login(login)
                .name(name)
                .profileImgUrl(profileImgUrl)
                .build();
    }


}
