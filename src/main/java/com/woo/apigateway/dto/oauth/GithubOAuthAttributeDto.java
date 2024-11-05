package com.woo.apigateway.dto.oauth;

import com.woo.apigateway.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

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
        log.info("Attribute : {}", attributes);

        return GithubOAuthAttributeDto.builder()
                .id(Optional.ofNullable(attributes.get("id")).map(Object::toString).orElse(""))
                .login(Optional.ofNullable(attributes.get("login")).map(Object::toString).orElse(""))
                .name(Optional.ofNullable(attributes.get("name")).map(Object::toString).orElse(""))
                .profileImgUrl(Optional.ofNullable(attributes.get("avatar_url")).map(Object::toString).orElse(""))
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
