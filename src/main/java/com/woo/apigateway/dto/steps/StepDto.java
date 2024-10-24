package com.woo.apigateway.dto.steps;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class StepDto {

    private String description;
    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss z", timezone = "GMT")
    private String lastUpdate;
    private Integer problemsCount;
    private Integer stepId;
    private String title;

}
