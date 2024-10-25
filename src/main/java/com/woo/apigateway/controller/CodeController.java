package com.woo.apigateway.controller;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import com.woo.apigateway.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @PostMapping("/execute")
    public CodeRespDto runCode(@RequestBody CodeReqDto codeReqDto) {
        return codeService.runCode(codeReqDto);
    }
}
