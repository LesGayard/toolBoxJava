package com.example.toolbox.services.utils;

import lombok.Getter;
import lombok.Setter;

import javax.sound.sampled.*;
import java.io.File;

@Setter
@Getter
public class Audio{
    public void init() throws Exception{
        AudioFormat audioFormat = new AudioFormat(96000,16,4,true,true);
        DataLine.Info infoTargetDataLine = new DataLine.Info(TargetDataLine.class,audioFormat);
        TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(infoTargetDataLine);

        targetLine.open(audioFormat);
        targetLine.start();
        File outputFile = new File("src/main/resources/outPutFile.wav");

        AudioSystem.write(new AudioInputStream(targetLine),AudioFileFormat.Type.WAVE,outputFile);
        Thread.sleep(36000);
        targetLine.stop();
        targetLine.close();
    }

    public Audio() throws LineUnavailableException {
    }
}
