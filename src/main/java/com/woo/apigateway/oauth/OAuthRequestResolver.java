package com.woo.apigateway.oauth;

import com.woo.apigateway.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
public class OAuthRequestResolver implements OAuth2AuthorizationRequestResolver {
    private OAuth2AuthorizationRequestResolver defaultResolver;
    private HttpSession httpSession;

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        User user = (User) httpSession.getAttribute("user");

        return (user != null) ? null : defaultResolver.resolve(request);
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        return resolve(request);
    }
}
