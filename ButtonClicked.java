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
    private JButton toggleSpeed;
    private JPanel alLiMaArea;
    private JTextArea alerts;
    private JButton minMap;
    private JTextArea licensePlate;
    private JTextArea licenseData;
    private JPanel map;
    
    private boolean speedIsMin = false;
    private boolean mapIsMin= false;
    //Toggle minimize Speed params
    ButtonClicked(JPanel all, JButton toggleSpeed, JPanel alLiMaArea, JTextArea alerts, JButton minMap, JTextArea licensePlate, JPanel map){
        
    }
    //Toggle maximize alerts params
    ButtonClicked(JPanel area, JButton minMap, JPanel jpmap, JTextArea jtAlert, JTextArea jtLicensePt, JTextArea jtLicense){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
    }
    
}
