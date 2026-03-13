package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.service.LiveVitalsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LiveVitalsController {

    private final LiveVitalsService service;

    public LiveVitalsController(LiveVitalsService service) {
        this.service = service;
    }

    @GetMapping("/live/vitals")
    public Map<String, Object> getVitals() {
        return service.generateVitals();
    }
}