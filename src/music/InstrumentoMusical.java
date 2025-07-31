/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author USER
 */
public class InstrumentoMusical {
    public void emitir_sonido(){
        Player new_player = new Player();
        CountDownLatch latch = new CountDownLatch(1);
        
        try {
            new_player.Play("sonido.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Piano.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Emitiendo sonido.");
        
        showimagejframe imageWindow = new showimagejframe("sonido.jpg", () -> {
            new_player.Stop();
            System.out.println("Ventana cerrada. Volviendo al menu principal...");
            latch.countDown();
        });
        
        try {
            latch.await(); // Wait until latch is released (window closed)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void tocar_cancion() {
        Player new_player = new Player();
        CountDownLatch latch = new CountDownLatch(1);

        try {
            new_player.Play("tocar_cancion.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(Piano.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Reproduciendo cancion.");
        System.out.println("Cierre la ventana para detener la cancion.");
        
        showimagejframe imageWindow = new showimagejframe("sonido.jpg", () -> {
            new_player.Stop();
            System.out.println("Ventana cerrada. Volviendo al menu principal...");
            latch.countDown();
        });
        
         try {
            latch.await(); // Wait until latch is released (window closed)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    } 
}