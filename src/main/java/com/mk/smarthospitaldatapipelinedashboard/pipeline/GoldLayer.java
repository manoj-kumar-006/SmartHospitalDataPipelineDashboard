package com.mk.smarthospitaldatapipelinedashboard.pipeline;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;

public class GoldLayer {

    public Map<String, Long> diagnosisReport(List<Patient> patients){

        return patients.stream()
                .collect(Collectors.groupingBy(
                        Patient::getDiagnosis,
                        Collectors.counting()
                ));

    }
}