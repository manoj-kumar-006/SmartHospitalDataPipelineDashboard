package com.mk.smarthospitaldatapipelinedashboard.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.mk.smarthospitaldatapipelinedashboard.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}