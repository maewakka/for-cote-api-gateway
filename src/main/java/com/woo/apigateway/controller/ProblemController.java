package com.woo.apigateway.controller;

import com.woo.apigateway.dto.problem.ProblemDto;
import com.woo.apigateway.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    @GetMapping("/problem/{problemId}")
    public ProblemDto getProblem(@PathVariable("problemId") Long problemId) {
        return problemService.getProblem(problemId);
    }

}
