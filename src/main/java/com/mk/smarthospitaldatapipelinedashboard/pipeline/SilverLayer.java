package com.mk.smarthospitaldatapipelinedashboard.pipeline;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;

import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class SilverLayer {

    public List<Patient> cleanPatients(List<Patient> patients) {

        List<Patient> cleaned = patients.stream()
                .filter(p -> p.getPatientId() > 0)
                .filter(p -> p.getDiagnosis() != null && !p.getDiagnosis().isEmpty())
                .collect(Collectors.toList());

        writeToSilver(cleaned);

        return cleaned;
    }

    private void writeToSilver(List<Patient> patients) {

        try {

            FileWriter writer = new FileWriter("silver/patients_clean.csv");

            writer.write("patient_id,admission_date,diagnosis,doctor_id\n");

            for (Patient p : patients) {

                writer.write(
                        p.getPatientId() + "," +
                                p.getAdmissionDate() + "," +
                                p.getDiagnosis() + "," +
                                p.getDoctorId() + "\n"
                );
            }

            writer.close();

            System.out.println("Silver Layer file created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}