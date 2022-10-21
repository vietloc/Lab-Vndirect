/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab6;

import java.util.Arrays;
import static java.util.Arrays.stream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class SimpleThreadSample {
    public static void main(String[] args) {  
        
        //int[] arr = {1,2,3,4};
//        new Thread(
//                ()->{
//                    stream(arr).forEach(ele->System.out.println(ele));
//                }
//        ).start();
//        new Thread(
//        ()-> {
//            Arrays.stream(arr).forEach(ele->{
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(SimpleThreadSample.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                System.out.println(ele);
//            });
//        }
//        ).start();
        Runnable message = new PrintMessage("Say helli to everyone");
        new Thread(message).start();
//        new Thread(message).start();
        
    }
}
