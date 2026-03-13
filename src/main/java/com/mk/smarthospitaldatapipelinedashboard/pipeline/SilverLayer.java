package com.mk.smarthospitaldatapipelinedashboard.pipeline;
import java.util.List;
import java.util.stream.Collectors;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;

public class SilverLayer {

    public List<Patient> cleanData(List<Patient> patients){

        return patients.stream()
                .filter(p -> p.getPatientId() != 0)
                .collect(Collectors.toList());

    }

}
