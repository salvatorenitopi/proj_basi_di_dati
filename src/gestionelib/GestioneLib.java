/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionelib;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author salvatorenitopi
 */




public class GestioneLib {
    

    public static void main(String[] args) {
        
        //new Login().setVisible(true);
      
        GestioneLib loader = new GestioneLib();
        
        loader.exe ();
 
    }
    
    
    public void exe (){
        final int MAX = 100;
        final JFrame frame = new JFrame("Gestione Libreria");
        
 
        // creo progress bar
        final JProgressBar pb = new JProgressBar();
        pb.setMinimum(0);
        pb.setMaximum(MAX);
        pb.setStringPainted(true);
 
        // aggiungo la progress bar al frame
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);       
        
        JLabel testo=new JLabel("Verifica credenziali utente in corso...");
        frame.getContentPane().add(testo);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 80);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        
        frame.setVisible(true);
        
        
 
        // aggiorno progress bar
        for (int i = 0; i <= MAX; i++) {
            final int currentValue = i;
            int wait = 40;
            
                if (currentValue == 0){
                    pb.setVisible (false);
                    testo.setText ("Avvio del programma in corso...");
                    wait = 2000;
                }
                
                if (currentValue == 1){
                    pb.setVisible (true);
                    testo.setText ("Caricamento database...");
                    }
            
                if (currentValue == 29){
                    testo.setText ("Caricamento database...");
                    wait = 1500;
                }
                
                if (currentValue == 41){
                    testo.setText ("Caricamento impostazioni predefinite...");
                    wait = 700;
                }
                
                if (currentValue == 67){
                    testo.setText ("Caricamento GUI in corso...");
                    wait = 700;
                }
                
                if (currentValue > 67){
                    wait = 100;
                }
                
                if (currentValue > 99){
                    wait = 700;
                }
                
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(wait);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
            }
        }
        
        
        frame.setVisible (false);
        new Login().setVisible(true);
    }
}