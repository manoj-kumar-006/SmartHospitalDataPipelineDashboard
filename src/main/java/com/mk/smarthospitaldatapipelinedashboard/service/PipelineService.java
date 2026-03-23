package com.mk.smarthospitaldatapipelinedashboard.service;

import com.mk.smarthospitaldatapipelinedashboard.repository.PatientRepository;
import com.mk.smarthospitaldatapipelinedashboard.repository.VitalsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipelineService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VitalsRepository vitalsRepository;

    public void runPipeline(){

        long totalPatients = patientRepository.count();

        double avgHeartRate = vitalsRepository.findAll()
                .stream()
                .mapToInt(v -> v.getHeartRate())
                .average()
                .orElse(0);

        System.out.println("Total Patients: " + totalPatients);
        System.out.println("Average Heart Rate: " + avgHeartRate);
    }
}