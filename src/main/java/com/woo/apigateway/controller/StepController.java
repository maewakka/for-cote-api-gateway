package com.woo.apigateway.controller;

import com.woo.apigateway.dto.steps.StepDto;
import com.woo.apigateway.dto.steps.StepProblemDto;
import com.woo.apigateway.service.StepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StepController {

    private final StepService stepService;

    @GetMapping("/step")
    public List<StepDto> getSteps() {
        return stepService.getSteps();
    }

    @GetMapping("/step/{stepId}")
    public List<StepProblemDto> getStepProblems(@PathVariable("stepId") Long stepId) {
        return stepService.getStepProblems(stepId);
    }

}
