package com.woo.apigateway.controller;

import com.woo.apigateway.dto.ais.OptimizeReqDto;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.oauth.CurrentUser;
import com.woo.apigateway.service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping("/optimize")
    public String optimizeCode(@CurrentUser User user, @RequestBody OptimizeReqDto reqDto) {
        return aiService.optimizeCode(user, reqDto);
    }

}
