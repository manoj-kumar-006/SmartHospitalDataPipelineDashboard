package com.mk.smarthospitaldatapipelinedashboard.controller;

import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import com.mk.smarthospitaldatapipelinedashboard.repository.LabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labs")
public class LabController {

    @Autowired
    private LabRepository repository;

    @PostMapping
    public LabResult addLab(@RequestBody LabResult lab){
        return repository.save(lab);
    }

    @GetMapping
    public List<LabResult> getLabs(){
        return repository.findAll();
    }
}