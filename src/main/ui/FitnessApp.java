package ui;

import ui.tools.AnalyzeMeasurementsGUI;
import ui.tools.MaintenanceCaloriesGUI;
import ui.tools.MealTrackerGUI;
import ui.tools.TrackCaloriesGUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


//Represents the Health & Fitness application.
public class FitnessApp extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    JButton btn5;

    // EFFECTS: constructs List Of Measurements and runs the Health & Fitness application
    public FitnessApp() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Health &Fitness Application");
        pack();
        setVisible(true);
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Home Page"));
        add(panel);
        setSize(3000, 3000);
        displayMenu();
    }

    /*
     *EFFECTS: displays menu of options to user
     */
    public void displayMenu() {
        btn1 = new JButton("Track Calories");
        btn2 = new JButton("Analyze Measurements");
        btn3 = new JButton("Calculate Maintenance Calories");
        btn4 = new JButton("Track Meals for Today");
        btn5 = new JButton("Quit The Application");
        btn1.setBounds(200, 200, 300, 100);
        btn2.setBounds(200, 300, 300, 100);
        btn3.setBounds(200, 400, 300, 100);
        btn4.setBounds(200, 500, 300, 100);
        btn5.setBounds(200, 600, 300, 100);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
    }

    /*
     *EFFECTS: Plays the audio file (i.e., the .wav file)
     */

    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     *EFFECTS: Performs the action associated with a particular button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            playSound("./data/StarWars3.wav");
            new TrackCaloriesGUI();
        } else if (e.getSource() == btn2) {
            analyze();
        } else if (e.getSource() == btn3) {
            playSound("./data/StarWars3.wav");
            new MaintenanceCaloriesGUI();

        } else if (e.getSource() == btn5) {
            System.exit(0);

        } else if (e.getSource() == btn4) {
            playSound("./data/StarWars3.wav");
            new MealTrackerGUI();
        }
    }

    //EFFECTS: Runs the analyze measurements feature of the application
    public void analyze() {
        playSound("./data/StarWars3.wav");
        try {
            new AnalyzeMeasurementsGUI();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}


