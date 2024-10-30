package com.woo.apigateway.feign;

import com.woo.apigateway.dto.ais.OptimizeReqDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ais-api", url = "${api-server.ais}")
public interface AiApiClient {
    @PostMapping("/optimize")
    String optimizeCode(@RequestBody OptimizeReqDto reqDto);
}
