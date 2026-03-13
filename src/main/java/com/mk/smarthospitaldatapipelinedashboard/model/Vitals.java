package com.mk.smarthospitaldatapipelinedashboard.model;
public class Vitals {

    private int patientId;
    private String timestamp;
    private int heartRate;
    private double temperature;
    private String bloodPressure;

    public Vitals(int patientId, String timestamp, int heartRate, double temperature, String bloodPressure) {
        this.patientId = patientId;
        this.timestamp = timestamp;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
    }

    public int getPatientId() { return patientId; }
    public String getTimestamp() { return timestamp; }
    public int getHeartRate() { return heartRate; }
}
