package com.woo.apigateway.controller;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import com.woo.apigateway.dto.enums.Language;
import com.woo.apigateway.entity.User;
import com.woo.apigateway.oauth.CurrentUser;
import com.woo.apigateway.service.CodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @PostMapping("/execute")
    public CodeRespDto runCode(@RequestBody CodeReqDto codeReqDto) {
        return codeService.runCode(codeReqDto);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCode(@RequestBody CodeReqDto codeReqDto) {
        codeService.saveCode(codeReqDto);

        return ResponseEntity.ok("success");
    }

    @GetMapping("/code")
    public String getCode(@CurrentUser User user, @RequestParam("problem_id") Long problemId, @RequestParam("language") Language language) {
        return codeService.getCode(user, problemId, language);
    }
}
