package com.mk.smarthospitaldatapipelinedashboard.repository;

import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Find patients by diagnosis
    List<Patient> findByDiagnosis(String diagnosis);

}