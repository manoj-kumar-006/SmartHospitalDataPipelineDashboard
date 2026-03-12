package com.mk.smarthospitaldatapipelinedashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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

public class Labs1{

}