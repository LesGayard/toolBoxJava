package com.example.toolbox.services.utils;

import lombok.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Data
public class Audio{
    private Long currentFrame = 0L;

    private String status = null;

    private static File outputFile = new File("src/main/resources/outPutFile.wav");
    private AudioInputStream inputStream = AudioSystem.getAudioInputStream(outputFile);
    private Clip clip = AudioSystem.getClip();
    private Logger logger = LoggerFactory.getLogger(Audio.class);

    public void AudioPlayer(){
        Scanner scanner = new Scanner(System.in);
        try{
            File playBack = audioRecord();
            audioPlayback();
            play();
            logger.info("Player Playing");
            while ((true)){
                int c = scanner.nextInt();
                logger.info("choose options");
                choice(c);
                break;
            }
        }catch(Exception e){
            logger.error("Error Catch : " + e.getLocalizedMessage());
            scanner.close();
        }
    }
    private void choice(int c){
        switch (c){
            case 1:
                play();
                break;
            case 2:
                pause();
                break;
            case 3:
                stop();
                break;
            default:
                pause();
        }
    }

    public File audioRecord() throws Exception{
        AudioFormat audioFormat = new AudioFormat(96000,16,4,true,true);
        DataLine.Info infoTargetDataLine = new DataLine.Info(TargetDataLine.class,audioFormat);
        TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(infoTargetDataLine);
        targetLine.open(audioFormat);
        targetLine.start();

        AudioSystem.write(new AudioInputStream(targetLine),AudioFileFormat.Type.WAVE,outputFile);
        Thread.sleep(360);
        targetLine.stop();
        targetLine.close();
        return outputFile;
    }

    private void audioPlayback() throws Exception{
        /* TO DO: CHOOSE THE FILE TO PLABACK -> List - Search - Find - Play */
        inputStream = AudioSystem.getAudioInputStream(outputFile);
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    private void play(){
        logger.info("1 play");
        clip.start();
        status = " 1 play";
    }
    private void pause(){
        logger.info(" 2  pause ");
        if(status.equals(" 1 play")){
            logger.warn("Audio Already playing");
            return;
        }
        clip.close();
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        status = " 2 pause";
    }
    private void stop(){
        logger.info("3  Stop ");
       currentFrame = 0L;
       logger.info("Player Stop Close");
       clip.stop();
       clip.close();
       status = "3 stop";
    }

    public Audio() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
    }
}
