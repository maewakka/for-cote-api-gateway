package com.woo.apigateway.feign;

import com.woo.apigateway.dto.problem.ProblemDto;
import com.woo.apigateway.dto.steps.StepDto;
import com.woo.apigateway.dto.steps.StepProblemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "problems-api", url = "${api-server.problems}")
public interface ProblemsApiClient {

    @GetMapping("/step")
    List<StepDto> getSteps();

    @GetMapping("/step/{stepId}")
    List<StepProblemDto> getStepProblemsByStepId(@PathVariable("stepId") Long stepId);

    @GetMapping("/problem/{problemId}")
    ProblemDto getProblem(@PathVariable("problemId") Long problemId);

}
