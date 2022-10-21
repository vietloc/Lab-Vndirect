/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author AD
 */
public class ShowExampleActionListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        AwtExample1 screen = new AwtExample1();
        screen.setSize(250,400);
        screen.setVisible(true);
        
        screen.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });
    }
    
}
