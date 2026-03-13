package com.mk.smarthospitaldatapipelinedashboard.repository;

import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabRepository extends JpaRepository<LabResult, Integer> {

    // Find lab tests by patient id
    List<LabResult> findByPatientId(int patientId);

}