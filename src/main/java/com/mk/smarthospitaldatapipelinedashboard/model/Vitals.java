package com.mk.smarthospitaldatapipelinedashboard.model;

import jakarta.persistence.*;

@Entity
public class Vitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    private int patientId;
    private String timestamp;
    private int heartRate;
    private double temperature;
    private String bloodPressure;

    // Default constructor
    public Vitals(){}

    // Constructor used for CSV ingestion
    public Vitals(int patientId, String timestamp, int heartRate,
                  double temperature, String bloodPressure) {

        this.patientId = patientId;
        this.timestamp = timestamp;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
    }

    public int getRecordId() { return recordId; }
    public int getPatientId() { return patientId; }
    public String getTimestamp() { return timestamp; }
    public int getHeartRate() { return heartRate; }
    public double getTemperature() { return temperature; }
    public String getBloodPressure() { return bloodPressure; }

    public void setRecordId(int recordId) { this.recordId = recordId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
}