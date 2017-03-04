/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstoneinterface;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
 
import static javafx.concurrent.Worker.State.FAILED;
/**
 *
 * @author 100514985
 */
public class CapstoneInterface extends JFrame{
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
    
    private JPanel all = new JPanel();
    private ButtonClicked buttonClicked = new ButtonClicked();
    
    private JPanel spNotArea = new JPanel();
    private JPanel speedArea = new JPanel();
    
    private final JLabel actualSpeedLabel = new JLabel("Actual Speed:");
    private JLabel actualSpeed = new JLabel(" 0");
    private final JLabel defaultSpeedLabel = new JLabel("Default Speed:");
    private JLabel defaultSpeed = new JLabel("60");
    
    
    private JButton toggleSpeed = new JButton("Sd");
    private JPanel notificationArea = new JPanel();
    
    private JPanel alLiMaArea = new JPanel();
    private JTextArea alerts = new JTextArea();
    private JButton maxAlerts = new JButton("Al");
    private JTextArea licensePlate = new JTextArea();
    private JTextArea license = new JTextArea();
    private final JPanel map = new JPanel(new BorderLayout());
    private final JLabel lblStatus = new JLabel();
    
    private Font text = new Font("Verdana", Font.PLAIN, 32);
    private Font text2 = new Font("Verdana", Font.PLAIN, 22);
    private Font licenseNumberText = new Font("Verdana", Font.PLAIN, 36);
    private Font alertText = new Font("Verdana", Font.PLAIN, 40);
    private Font speedNumText = new Font("Verdana", Font.PLAIN, 80);
    
    
    public CapstoneInterface() {
        super();
        initComponents();
    }
    private void initComponents() {
        createScene();
        all.setBackground(Color.red);
        
        spNotArea.setBackground(Color.red);
        speedArea.setBackground(Color.BLACK);
        
        actualSpeedLabel.setForeground(Color.red);
        actualSpeed.setForeground(Color.red);
        defaultSpeedLabel.setForeground(Color.red);
        defaultSpeed.setForeground(Color.red);
        
        notificationArea.setBackground(Color.BLACK);
        
        alLiMaArea.setBackground(Color.red);
        alerts.setBackground(Color.BLACK);
        alerts.setForeground(Color.red);
        licensePlate.setForeground(Color.red);
        licensePlate.setBackground(Color.BLACK);
        license.setBackground(Color.BLACK);
        license.setForeground(Color.red);
        map.add(jfxPanel, BorderLayout.CENTER);
        
        spNotArea.setBounds(0, 0, 307, 1000);
        speedArea.setBounds(0,0,265, 400);
        actualSpeedLabel.setBounds(0, 0, 1000, 50);
        actualSpeed.setBounds(60,60,100,100);
        defaultSpeedLabel.setBounds(0,190,400, 50);
        defaultSpeed.setBounds(60,260,200, 100);
        
        notificationArea.setBounds(0,410, 265,562);
        toggleSpeed.setBounds(265,520, 43, 100);
        
        alLiMaArea.setBounds(310, 0, 700, 1000);
        alerts.setBounds(0, 0, 690, 540);
        maxAlerts.setBounds(300, 545, 100, 40);
        licensePlate.setBounds(0, 590, 340, 56);
        license.setBounds(0, 642, 340, 330);
        map.setBounds(350, 590, 340, 382);
        
        actualSpeedLabel.setFont(text);
        defaultSpeedLabel.setFont(text);
        actualSpeed.setFont(speedNumText);
        defaultSpeed.setFont(speedNumText);
        
        alerts.setFont(alertText);
        license.setFont(text2);
        licensePlate.setFont(licenseNumberText);
        
        alerts.setText("All unit please respond. Robbery on 34th street");
        licensePlate.setText("License: L0B1B0L");
        license.setText("\nName: Alexander Wheadon \nAge: 21"+
                "     Gender: Male \n\nLicense No: W3277-01959-50817\n\n" + 
                "Address: 3981 Townline Rd. North, BlackStock, Ontario"+
                "\n\n<!> \tQuery On File");
        
        all.setLayout(null);
        spNotArea.setLayout(null);
        alLiMaArea.setLayout(null);
        speedArea.setLayout(null);
        
        alerts.setFocusable(false);
        alerts.setEditable(false);
        alerts.setWrapStyleWord(true);
        alerts.setLineWrap(true);
        
        license.setFocusable(false);
        license.setEditable(false);
        license.setWrapStyleWord(true);
        license.setLineWrap(true);
        
        licensePlate.setFocusable(false);
        licensePlate.setEditable(false);
        licensePlate.setWrapStyleWord(true);
        licensePlate.setLineWrap(true);
        
        alLiMaArea.add(licensePlate);
        alLiMaArea.add(license);
        alLiMaArea.add(map);
        alLiMaArea.add(maxAlerts);
        maxAlerts.addActionListener(buttonClicked);
        alLiMaArea.add(alerts);
        
        speedArea.add(actualSpeedLabel);
        speedArea.add(actualSpeed);
        speedArea.add(defaultSpeedLabel);
        speedArea.add(defaultSpeed);
        spNotArea.add(speedArea);
        
        spNotArea.add(notificationArea);
        spNotArea.add(toggleSpeed);
        toggleSpeed.addActionListener(buttonClicked);
        all.add(alLiMaArea);
        all.add(spNotArea);
        getContentPane().add(all);
        
        this.setResizable(false);
        setPreferredSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

    }
 
    private void createScene() {
 
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
 
                WebView view = new WebView();
                engine = view.getEngine();
 
                engine.titleProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                CapstoneInterface.this.setTitle(newValue);
                            }
                        });
                    }
                });
 
                engine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
                    @Override 
                    public void handle(final WebEvent<String> event) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                lblStatus.setText(event.getData());
                            }
                        });
                    }
                });
 
                engine.locationProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
//                                txtURL.setText(newValue);
                            }
                        });
                    }
                });
 
                engine.getLoadWorker().workDoneProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override 
                            public void run() {
                                //progressBar.setValue(newValue.intValue());
                            }
                        });
                    }
                });

                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {
 
                            public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                                if (engine.getLoadWorker().getState() == FAILED) {
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override public void run() {
                                            JOptionPane.showMessageDialog(
                                                    map,
                                                    (value != null) ?
                                                    engine.getLocation() + "\n" + value.getMessage() :
                                                    engine.getLocation() + "\nUnexpected error.",
                                                    "Loading error...",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    });
                                }
                            }
                        });

                jfxPanel.setScene(new Scene(view));
            }
        });
    }
 
    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            @Override 
            public void run() {
                String tmp = toURL(url);
 
                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
 
                engine.load(tmp);
            }
        });
    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
                return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                CapstoneInterface browser = new CapstoneInterface();
                browser.setVisible(true);
                browser.loadURL("https://www.google.ca/maps");
           }     
       });

    }
    
}
