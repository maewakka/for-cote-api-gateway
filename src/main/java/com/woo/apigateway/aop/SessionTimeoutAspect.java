package com.woo.apigateway.aop;

import com.woo.apigateway.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SessionTimeoutAspect {

    private final HttpSession session;

    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
    public void resetSessionTimeoutIfUserPresent() {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            session.setMaxInactiveInterval(30 * 60);
        }
    }
}