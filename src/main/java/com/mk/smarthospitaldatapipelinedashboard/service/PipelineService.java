package com.mk.smarthospitaldatapipelinedashboard.service;
import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;
import org.springframework.stereotype.Service;
import java.util.List;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.pipeline.*;
import com.mk.smarthospitaldatapipelinedashboard.ingestion.CsvReaderService;

@Service
public class PipelineService {

    public void runPipeline(){

        CsvReaderService reader = new CsvReaderService();

        List<Patient> patients = reader.readPatients("data/ehr.csv");
        List<Vitals> vitals = reader.readVitals("data/vitals.csv");
        List<LabResult> labs = reader.readLabs("data/labs.csv");

        System.out.println("Patients loaded: " + patients.size());
        System.out.println("Vitals loaded: " + vitals.size());
        System.out.println("Labs loaded: " + labs.size());
    }
}
