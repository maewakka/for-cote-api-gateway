package com.woo.apigateway.dto.codes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.woo.apigateway.dto.enums.Language;
import lombok.Data;

@Data
public class CodeReqDto {

    private Language language;
    private String id;
    private String code;
    private String input;
    @JsonProperty("problem_id")
    private Long problemId;

}
