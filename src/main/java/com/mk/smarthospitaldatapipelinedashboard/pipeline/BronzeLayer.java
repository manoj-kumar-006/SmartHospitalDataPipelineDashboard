package com.mk.smarthospitaldatapipelinedashboard.pipeline;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BronzeLayer {

    public void storeRaw(String source, String destination){

        try{
            Files.copy(Path.of(source), Path.of(destination),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
