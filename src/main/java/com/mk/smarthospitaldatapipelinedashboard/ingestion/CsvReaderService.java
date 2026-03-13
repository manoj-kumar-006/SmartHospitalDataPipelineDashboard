package com.mk.smarthospitaldatapipelinedashboard.ingestion;

import com.mk.smarthospitaldatapipelinedashboard.model.LabResult;
import com.mk.smarthospitaldatapipelinedashboard.model.Patient;
import com.mk.smarthospitaldatapipelinedashboard.model.Vitals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderService {

    public List<Patient> readPatients(String filePath){

        List<Patient> patients = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            br.readLine(); // skip header

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                patients.add(new Patient(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3]
                ));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return patients;
    }

    public List<Vitals> readVitals(String filePath){

        List<Vitals> vitals = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            br.readLine();

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                vitals.add(new Vitals(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        data[4]
                ));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return vitals;
    }
    public List<LabResult> readLabs(String filePath){

        List<LabResult> labs = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            br.readLine(); // skip header
            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                labs.add(
                        new LabResult(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                data[3]
                        )
                );
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return labs;
    }
}