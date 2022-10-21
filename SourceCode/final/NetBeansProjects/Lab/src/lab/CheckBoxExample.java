/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

/**
 *
 * @author AD
 */
public class CheckBoxExample extends Frame{
    public CheckBoxExample(){
        setLayout(new FlowLayout());
        
        Checkbox checkbox1 = new Checkbox("Lua chon 1");
        checkbox1.setFont(new Font("Arial", Font.BOLD,14));
        add(checkbox1);
        
        final Checkbox checkbox2 = new Checkbox("CheckBox 2");
        add(checkbox2);
        checkbox2.addItemListener(e->{
            System.out.println("value 2 = "+ checkbox2.getState());
        });
    }
    
}
