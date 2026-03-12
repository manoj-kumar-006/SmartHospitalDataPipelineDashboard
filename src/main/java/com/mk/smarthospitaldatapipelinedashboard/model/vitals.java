package com.mk.smarthospitaldatapipelinedashboard.model;

@Entity
public class Vitals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int patientId;
    private String timestamp;
    private int heartRate;
    private double temperature;
    private String bloodPressure;
}
