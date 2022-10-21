/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author AD
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame screen = new CheckBoxExample();
//        Frame screen1 = new AwtExample1();
        screen.setSize(500,100);
        screen.setVisible(true);
//        screen1.setSize(500,100);
//        screen1.setVisible(true);
        
        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                //an exit duoc
                System.exit(1);
            }
        });
       
    }
}
