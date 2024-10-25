package com.woo.apigateway.dto.codes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeRespDto {

    private Boolean success;
    private String output;

}
