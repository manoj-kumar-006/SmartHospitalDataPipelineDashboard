package com.mk.smarthospitaldatapipelinedashboard.pipeline;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GoldLayer {

    // -------------------------
    // Top Diseases Analytics
    // -------------------------

    public Map<String, Long> getTopDiseases(List<Patient> patients){

        Map<String, Long> result = patients.stream()
                .collect(Collectors.groupingBy(
                        Patient::getDiagnosis,
                        Collectors.counting()
                ));

        writeDiseaseReport(result);

        return result;
    }

    // -------------------------
    // Daily Admissions Analytics
    // -------------------------

    public Map<String, Long> getDailyAdmissions(List<Patient> patients){

        Map<String, Long> result = patients.stream()
                .collect(Collectors.groupingBy(
                        Patient::getAdmissionDate,
                        Collectors.counting()
                ));

        writeAdmissionsReport(result);

        return result;
    }

    // -------------------------
    // Average Heart Rate
    // -------------------------

    public double getAverageHeartRate(List<Vitals> vitals){

        return vitals.stream()
                .mapToInt(Vitals::getHeartRate)
                .average()
                .orElse(0);
    }

    // -------------------------
    // Write Disease Report
    // -------------------------

    private void writeDiseaseReport(Map<String, Long> data){

        try{

            FileWriter writer = new FileWriter("gold/disease_report.csv");

            writer.write("disease,count\n");

            for(Map.Entry<String, Long> entry : data.entrySet()){
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            writer.close();

            System.out.println("Gold disease report generated");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // -------------------------
    // Write Admissions Report
    // -------------------------

    private void writeAdmissionsReport(Map<String, Long> data){

        try{

            FileWriter writer = new FileWriter("gold/admissions_report.csv");

            writer.write("date,count\n");

            for(Map.Entry<String, Long> entry : data.entrySet()){
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            writer.close();

            System.out.println("Gold admissions report generated");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}