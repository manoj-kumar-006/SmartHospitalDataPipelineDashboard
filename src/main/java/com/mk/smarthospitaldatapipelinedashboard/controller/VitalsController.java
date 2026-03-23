package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;
import com.mk.smarthospitaldatapipelinedashboard.repository.VitalsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitals")
public class VitalsController {

    @Autowired
    private VitalsRepository repository;

    @PostMapping
    public Vitals addVitals(@RequestBody Vitals vitals){
        return repository.save(vitals);
    }

    @GetMapping
    public List<Vitals> getVitals(){
        return repository.findAll();
    }
}