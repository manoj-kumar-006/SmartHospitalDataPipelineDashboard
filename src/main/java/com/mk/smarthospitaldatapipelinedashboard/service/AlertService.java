package com.mk.smarthospitaldatapipelinedashboard.service;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;

import java.util.List;

public class AlertService {

    public void checkVitals(List<Vitals> vitals){

        for(Vitals v : vitals){

            if(v.getHeartRate() > 100){
                System.out.println("ALERT: High Heart Rate detected for patient "
                        + v.getPatientId());
            }
        }
    }
}