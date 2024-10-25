package com.woo.apigateway.config;

import com.woo.apigateway.oauth.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final OAuthUserService oAuthUserService;
    private final HttpSession httpSession;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final OAuthSuccessHandler oAuthSuccessHandler;
    private final OAuthFailureHandler oAuthFailureHandler;
    private final OAuthLogoutHandler oAuthLogoutHandler;

    @Value("${redirect-front-url}")
    private String redirectUrl;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationRequestResolver defaultResolver = new DefaultOAuth2AuthorizationRequestResolver(
                clientRegistrationRepository, "/oauth2/authorization"
        );

        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).sessionFixation().none())
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth -> oauth
                        .userInfoEndpoint(c -> c.userService(oAuthUserService))
                        .authorizationEndpoint(c -> c.authorizationRequestResolver(new OAuthRequestResolver(defaultResolver, httpSession)))
                        .successHandler(oAuthSuccessHandler)
                        .failureHandler(oAuthFailureHandler))
                .logout(logout -> logout.addLogoutHandler(oAuthLogoutHandler).logoutSuccessUrl(redirectUrl).invalidateHttpSession(true));
        return http.build();
    }

}
