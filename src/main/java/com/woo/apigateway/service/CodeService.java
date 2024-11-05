package com.woo.apigateway.service;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import com.woo.apigateway.dto.enums.Language;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.feign.CodeApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CodeService {

    private final CodeApiClient codeApiClient;

    public CodeRespDto runCode(CodeReqDto codeReqDto) {
        return codeApiClient.runCode(codeReqDto);
    }

    public void saveCode(CodeReqDto codeReqDto) {
        codeApiClient.saveCode(codeReqDto);
    }

    public String getCode(User user, Long problemId, Language language) {
        String code = codeApiClient.getCode(user.getId(), problemId, language);
        log.info("Code : {}", code);
        return code;
    }
}
