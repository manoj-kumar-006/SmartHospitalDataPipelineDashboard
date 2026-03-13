package com.mk.smarthospitaldatapipelinedashboard.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.smarthospitaldatapipelinedashboard.service.PipelineService;

@RestController
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping("/run-pipeline")
    public String runPipeline(){

        pipelineService.runPipeline();

        return "Pipeline executed successfully";
    }
}