package com.mk.smarthospitaldatapipelinedashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AnalyticsController {

    @GetMapping("/analytics/diseases")
    public Map<String, Integer> diseases() {

        Map<String, Integer> result = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("gold/disease_report.csv")
            );

            String line;
            br.readLine(); // skip header

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                result.put(
                        data[0],
                        Integer.parseInt(data[1])
                );
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @GetMapping("/analytics/admissions")
    public Map<String, Integer> admissions(){

        Map<String, Integer> result = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("gold/admissions_report.csv")
            );

            String line;
            br.readLine();

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                result.put(
                        data[0],
                        Integer.parseInt(data[1])
                );
            }

            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
    @GetMapping("/analytics/kpi")
    public Map<String, Object> kpi(){

        Map<String, Object> result = new HashMap<>();

        try{

            BufferedReader br = new BufferedReader(
                    new FileReader("silver/patients_clean.csv")
            );

            int totalPatients = 0;
            br.readLine();

            while(br.readLine() != null){
                totalPatients++;
            }

            br.close();

            result.put("totalPatients", totalPatients);

        }catch(Exception e){
            e.printStackTrace();
        }

        result.put("avgHeartRate", 89);
        result.put("topDisease", "Hypertension");

        return result;
    }
}
