package music;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Player {
    private Clip clip;
    
    public void Play (String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
               
        File file = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY); //optional loop while window is open
 
    }
    
    public void Stop() {
        if(clip != null && clip.isRunning()){
            clip.stop();
            clip.close();
        }
    }
}
