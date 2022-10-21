/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import static java.util.Arrays.stream;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author AD
 */
public class PrintMessage implements Runnable{

    private String message;
    
    private int number = 1;
    private boolean alive = true;
    
    public void setAlive(boolean alive){this.alive = alive;}
    
    public PrintMessage(String ms){
        this.message = ms;
    }
    @Override
    public synchronized void run() {
        String[] elements = message.split(" ");
        stream(elements).forEach(ele ->{
            System.out.println(Thread.currentThread().getName()+" print "+ele);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(PrintMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
try {
            Thread.sleep((int)(Math.random()*3)*1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        };
        
//        Thread current = Thread.currentThread();
//        while(alive){
//            number++;
//            System.out.println(current.getName()+ "Number is\""+ number + "\"");
//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(PrintMessage.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        System.out.println(current.getName()+"is stoped!");
    
     } 

