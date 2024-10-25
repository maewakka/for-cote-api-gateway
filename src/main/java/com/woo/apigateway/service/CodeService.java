package com.woo.apigateway.service;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import com.woo.apigateway.feign.CodeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeApiClient codeApiClient;

    public CodeRespDto runCode(CodeReqDto codeReqDto) {
        return codeApiClient.runCode(codeReqDto);
    }

}
