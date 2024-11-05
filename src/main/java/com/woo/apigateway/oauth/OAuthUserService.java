package com.woo.apigateway.oauth;

import com.woo.apigateway.dto.oauth.GithubOAuthAttributeDto;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.entity.UserAssistCount;
import com.woo.apigateway.repository.UserAssistCountRepository;
import com.woo.apigateway.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthUserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;
    private final UserAssistCountRepository userAssistCountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        GithubOAuthAttributeDto githubOAuthAttributeDto = GithubOAuthAttributeDto.of(oAuth2User.getAttributes());
        User user = saveOrLoadUser(githubOAuthAttributeDto);
        httpSession.setAttribute("user", user);

        return oAuth2User;
    }

    private User saveOrLoadUser(GithubOAuthAttributeDto githubOAuthAttributeDto) {
        User savedUser = userRepository.findUserById(githubOAuthAttributeDto.getId());

        if(savedUser != null) {
            return savedUser;
        } else {
            User user = userRepository.save(githubOAuthAttributeDto.toEntity());
            userAssistCountRepository.save(new UserAssistCount(user));

            return user;
        }
    }
}
