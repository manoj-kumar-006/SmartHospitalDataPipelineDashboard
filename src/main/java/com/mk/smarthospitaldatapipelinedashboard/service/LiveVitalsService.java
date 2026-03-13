package com.mk.smarthospitaldatapipelinedashboard.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class LiveVitalsService {

    public Map<String,Object> generateVitals(){

        Random random = new Random();

        Map<String,Object> vitals = new HashMap<>();

        int heartRate = 70 + random.nextInt(50);
        double temperature = 97 + random.nextDouble()*5;
        int systolic = 110 + random.nextInt(40);
        int diastolic = 70 + random.nextInt(20);

        vitals.put("heartRate",heartRate);
        vitals.put("temperature",temperature);
        vitals.put("bloodPressure",systolic+"/"+diastolic);

        return vitals;
    }
}