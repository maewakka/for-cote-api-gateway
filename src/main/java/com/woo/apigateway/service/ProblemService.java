package com.woo.apigateway.service;

import com.woo.apigateway.dto.problem.ProblemDto;
import com.woo.apigateway.feign.ProblemsApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemsApiClient problemsApiClient;

    public ProblemDto getProblem(Long problemId) {
        return problemsApiClient.getProblem(problemId);
    }

}
