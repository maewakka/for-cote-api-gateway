package com.woo.apigateway.service;

import com.woo.apigateway.dto.steps.StepDto;
import com.woo.apigateway.dto.steps.StepProblemDto;
import com.woo.apigateway.feign.ProblemsApiClient;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StepService {

    private final ProblemsApiClient problemsApiClient;

    public List<StepDto> getSteps() {
        return problemsApiClient.getSteps();
    }

    public List<StepProblemDto> getStepProblems(Long stepId) {
        return problemsApiClient.getStepProblemsByStepId(stepId);
    }

//    TEST4

}
