package com.mk.smarthospitaldatapipelinedashboard.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_reports", schema = "test")
public class LabResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;

    private int patientId;
    private String testName;
    private String result;
    private String timestamp;

    public LabResult(){}

    public int getTestId() { return testId; }
    public int getPatientId() { return patientId; }
    public String getTestName() { return testName; }
    public String getResult() { return result; }
    public String getTimestamp() { return timestamp; }

    public void setTestId(int testId) { this.testId = testId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setTestName(String testName) { this.testName = testName; }
    public void setResult(String result) { this.result = result; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}