package com.mk.smarthospitaldatapipelinedashboard.repository;

import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRepository extends JpaRepository<LabResult,Integer> {
}