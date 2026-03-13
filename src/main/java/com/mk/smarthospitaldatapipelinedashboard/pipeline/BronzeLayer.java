package com.mk.smarthospitaldatapipelinedashboard.pipeline;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BronzeLayer {

    public void storeRawData(String source, String destination) {

        try {

            Files.createDirectories(Path.of("bronze"));

            Files.copy(
                    Path.of(source),
                    Path.of(destination),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Raw data stored in Bronze Layer");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}