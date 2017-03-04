/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstoneinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author 100514985
 */
public class ButtonClicked implements ActionListener{
    private JPanel all;
    private JPanel spNotArea;
    private JButton minSpeed;
    private JPanel alLiMaArea;
    private JTextArea alerts;
    private JButton minMap;
    private JTextArea licensePlate;
    private JTextArea licenseData;
    private JPanel map;
    
    private boolean speedIsMin = false;
    private boolean mapIsMin= false;
    //Toggle minimize Speed params
    ButtonClicked(JPanel all, JButton minSpeed, JPanel alLiMaArea, JTextArea alerts, JButton minMap, JTextArea licensePlate, JTextArea licenseData, JPanel map){
        this.all = all;
        this.minSpeed = minSpeed;
        this.alLiMaArea = alLiMaArea;
        this.alerts = alerts;
        this.minMap = minMap;
        this.licensePlate = licensePlate;
        this.licenseData = licenseData;
        this.map = map
    }
    //Toggle maximize alerts params
    ButtonClicked(JPanel alLiMaArea, JButton minMap, JPanel map, JTextArea alerts, JTextArea jtLicensePt, JTextArea jtLicense){
        this.alLiMaArea = alLiMaArea;
        this.minMap = minMap;
        this.map = map;
        this.alerts = alerts;
        this.licensePlate = licensePlate;
        this.licenseData = licenseData;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
    }
    
}
