package com.mk.smarthospitaldatapipelinedashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {

    @Id
    private int patientId;
    private String admissionDate;
    private String diagnosis;
    private String doctorId;

    // Default constructor (required by JPA)
    public Patient(){}

    // Constructor used by CSV reader
    public Patient(int patientId, String admissionDate, String diagnosis, String doctorId) {
        this.patientId = patientId;
        this.admissionDate = admissionDate;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
    }

    public int getPatientId() { return patientId; }
    public String getAdmissionDate() { return admissionDate; }
    public String getDiagnosis() { return diagnosis; }
    public String getDoctorId() { return doctorId; }

    public void setPatientId(int patientId) { this.patientId = patientId; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
}