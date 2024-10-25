package com.woo.apigateway.feign;

import com.woo.apigateway.dto.codes.CodeReqDto;
import com.woo.apigateway.dto.codes.CodeRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "codes-api", url = "${api-server.codes}")
public interface CodeApiClient {

    @PostMapping("/execute")
    CodeRespDto runCode(@RequestBody CodeReqDto codeReqDto);

}
