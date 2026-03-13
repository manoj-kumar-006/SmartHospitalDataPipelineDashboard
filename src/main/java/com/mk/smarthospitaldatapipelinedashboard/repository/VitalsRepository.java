package com.mk.smarthospitaldatapipelinedashboard.repository;

import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalsRepository extends JpaRepository<Vitals, Integer> {

    // Find vitals by patient id
    List<Vitals> findByPatientId(int patientId);

}
