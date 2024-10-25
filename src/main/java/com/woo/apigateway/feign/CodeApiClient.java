package com.woo.apigateway.feign;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import com.woo.apigateway.dto.enums.Language;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codes-api", url = "${api-server.codes}")
public interface CodeApiClient {

    @PostMapping("/execute")
    CodeRespDto runCode(@RequestBody CodeReqDto codeReqDto);

    @PostMapping("/save")
    String saveCode(@RequestBody CodeReqDto codeReqDto);

    @GetMapping("/code")
    String getCode(@RequestParam("email") String email, @RequestParam("problemId") Long problemId, @RequestParam("language") Language language);

}
