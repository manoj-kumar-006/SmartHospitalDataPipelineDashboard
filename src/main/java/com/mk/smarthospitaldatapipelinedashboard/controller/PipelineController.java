package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.service.PipelineService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pipeline")
public class PipelineController {

    private final PipelineService service;

    public PipelineController(PipelineService service){
        this.service = service;
    }

    @GetMapping("/run")
    public String run(){
        service.runPipeline();
        return "Pipeline executed successfully";
    }
}