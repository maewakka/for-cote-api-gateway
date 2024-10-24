package com.woo.apigateway.dto.problem;

import lombok.Data;

import java.util.List;

@Data
public class ProblemDto {

    private String description;
    private List<Example> examples;
    private String input;
    private String output;
    private String title;
    private Long updateCount;


    @Data
    public static class Example {
        private String input;
        private String output;
    }
}
