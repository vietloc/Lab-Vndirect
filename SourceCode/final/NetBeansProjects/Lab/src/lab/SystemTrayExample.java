/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author AD
 */
public class SystemTrayExample {
    public static void main(String[] args) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        
        Icon icon = UIManager.getIcon("OptionPane.informationIcon");
        Image image = ((ImageIcon) icon).getImage();
        
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo", null);
        trayIcon.addActionListener(new ShowExampleActionListener());
        tray.add(trayIcon);
    }
}
