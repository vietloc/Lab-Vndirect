import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

interface WindowClosing extends WindowListener{
    @Override
    default void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    default void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    default void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    default void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    default void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    default void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
}

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();

        Button button = new Button("Press me");
        screen.add(button);

        // button.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {

        //         JOptionPane.showMessageDialog(null, "Welcome to Java by Example", "Java Sample",
        //                 JOptionPane.INFORMATION_MESSAGE);

        //     }

        // });

        //==5

        // button.addActionListener(e -> {
        //         JOptionPane.showMessageDialog(null, "Info Box: Welcome to Java by Example", "Java Sample",
        //                 JOptionPane.INFORMATION_MESSAGE);

        // });
        // screen.setSize(400, 400);
        // screen.setVisible(true);

        //===6
        screen.addWindowListener((WindowClosing)(e)->System.exit(1));
        screen.setSize(400, 400);
        screen.setVisible(true);
    }

}
