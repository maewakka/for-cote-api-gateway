package com.woo.apigateway.dto.codes;

import com.woo.apigateway.dto.enums.Language;
import lombok.Data;

@Data
public class CodeReqDto {

    private Language language;
    private String email;
    private String code;
    private String input;

}
