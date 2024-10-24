package com.woo.apigateway.dto.steps;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StepProblemDto {
    private Long id;;
    private String correctPercentage;
    private String description;
    private Integer problemId;
    private Long solvedCount;
    private Integer stepId;
    private Long submissionCount;
    private String title;
    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss z", timezone = "GMT")
    private String createdAt;

    @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss z", timezone = "GMT")
    private String updatedAt;
}
