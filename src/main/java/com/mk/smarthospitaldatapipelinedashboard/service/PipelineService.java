package com.mk.smarthospitaldatapipelinedashboard.service;

import com.mk.smarthospitaldatapipelinedashboard.ingestion.CsvReaderService;
import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;
import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import com.mk.smarthospitaldatapipelinedashboard.pipeline.BronzeLayer;
import com.mk.smarthospitaldatapipelinedashboard.pipeline.SilverLayer;
import com.mk.smarthospitaldatapipelinedashboard.pipeline.GoldLayer;
import com.mk.smarthospitaldatapipelinedashboard.repository.PatientRepository;
import com.mk.smarthospitaldatapipelinedashboard.repository.VitalsRepository;
import com.mk.smarthospitaldatapipelinedashboard.repository.LabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PipelineService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VitalsRepository vitalsRepository;

    @Autowired
    private LabRepository labRepository;

    public void runPipeline() {

        CsvReaderService reader = new CsvReaderService();
        BronzeLayer bronze = new BronzeLayer();
        SilverLayer silver = new SilverLayer();
        GoldLayer gold = new GoldLayer();

        System.out.println("Starting Hospital Data Pipeline...");

        // -------------------------------
        // Bronze Layer
        // -------------------------------

        bronze.storeRawData(
                "src/main/resources/data/ehr.csv",
                "bronze/ehr_raw.csv"
        );

        bronze.storeRawData(
                "src/main/resources/data/vitals.csv",
                "bronze/vitals_raw.csv"
        );

        bronze.storeRawData(
                "src/main/resources/data/labs.csv",
                "bronze/labs_raw.csv"
        );

        // -------------------------------
        // Data Ingestion
        // -------------------------------

        List<Patient> rawPatients =
                reader.readPatients("src/main/resources/data/ehr.csv");

        List<Vitals> vitals =
                reader.readVitals("src/main/resources/data/vitals.csv");

        List<LabResult> labs =
                reader.readLabs("src/main/resources/data/labs.csv");

        System.out.println("Raw Patients: " + rawPatients.size());
        System.out.println("Vitals Records: " + vitals.size());
        System.out.println("Lab Records: " + labs.size());

        // -------------------------------
        // Silver Layer (Data Cleaning)
        // -------------------------------

        List<Patient> cleanPatients =
                silver.cleanPatients(rawPatients);

        System.out.println("Clean Patients: " + cleanPatients.size());

        // -------------------------------
        // Store Clean Data in Database
        // -------------------------------

        patientRepository.saveAll(cleanPatients);
        vitalsRepository.saveAll(vitals);
        labRepository.saveAll(labs);

        System.out.println("Data saved to PostgreSQL database.");

        // -------------------------------
        // Gold Layer (Analytics)
        // -------------------------------

        Map<String, Long> diseases =
                gold.getTopDiseases(cleanPatients);

        double avgHeartRate =
                gold.getAverageHeartRate(vitals);

        Map<String, Long> admissions =
                gold.getDailyAdmissions(cleanPatients);

        // -------------------------------
        // Display Analytics
        // -------------------------------

        System.out.println("\nTop Diseases:");
        diseases.forEach((disease, count) ->
                System.out.println(disease + " : " + count));

        System.out.println("\nAverage Heart Rate: " + avgHeartRate);

        System.out.println("\nDaily Admissions:");
        admissions.forEach((date, count) ->
                System.out.println(date + " : " + count));

        System.out.println("\nPipeline execution completed.");
    }
}