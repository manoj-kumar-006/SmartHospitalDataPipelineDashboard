package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return repository.save(patient);
    }

    @GetMapping
    public List<Patient> getPatients(){
        return repository.findAll();
    }
}