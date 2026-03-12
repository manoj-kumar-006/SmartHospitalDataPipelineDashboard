package com.mk.smarthospitaldatapipelinedashboard.model;

@Entity
public class Labs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int patientId;
    private String testName;
    private String result;
    private String timestamp;
}
