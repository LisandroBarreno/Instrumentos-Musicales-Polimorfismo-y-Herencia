/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package music;

/**
 *
 * @author USER
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class showimagejframe extends JFrame {
    public interface onWindowClosed {
        void handle();
    }
    
    public showimagejframe(String imagePath, onWindowClosed listener)
    {
        JPanel panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();
                
                if (image != null)
                {
                    int x = (getWidth() - image.getWidth(null)) / 2;
                    int y = (getHeight() - image.getHeight(null)) / 2;
                    g.drawImage(image, x, y, this);
                }
            }
        };
        
        this.getContentPane().add(panel);
        setSize(525, 525);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e){
                if (listener != null){
                    listener.handle();
                }
            }
        });

    }
}
