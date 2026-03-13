package com.mk.smarthospitaldatapipelinedashboard.model;
public class LabResult {

    private int patientId;
    private String testName;
    private String result;
    private String timestamp;

    public LabResult(int patientId, String testName, String result, String timestamp) {
        this.patientId = patientId;
        this.testName = testName;
        this.result = result;
        this.timestamp = timestamp;
    }

}