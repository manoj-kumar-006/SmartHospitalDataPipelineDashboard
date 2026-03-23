package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;
import com.mk.smarthospitaldatapipelinedashboard.repository.PatientRepository;
import com.mk.smarthospitaldatapipelinedashboard.repository.VitalsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AnalyticsController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VitalsRepository vitalsRepository;

    @GetMapping("/analytics/kpi")
    public Map<String,Object> getKPI(){

        Map<String,Object> result = new HashMap<>();

        long totalPatients = patientRepository.count();

        double avgHeartRate = vitalsRepository.findAll()
                .stream()
                .mapToInt(Vitals::getHeartRate)
                .average()
                .orElse(0);

        result.put("totalPatients", totalPatients);
        result.put("avgHeartRate", avgHeartRate);

        return result;
    }
}