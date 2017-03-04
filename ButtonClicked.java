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
    private JButton maxAlerts;
    private JTextArea licensePlate;
    private JTextArea licenseData;
    private JPanel map;
    //Toggle minimize Speed
    ButtonClicked(){
        
    }
    //Toggle maximize alerts
    ButtonClicked(JPanel jp, JButton jb, JPanel jpmap, JTextArea jtAlert, JTextArea jtLicensePt, JTextArea jtLicense){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
    }
    
}
