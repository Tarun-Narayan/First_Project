package ui;

import model.UserMaintenanceCalories;
import model.ListOfMeasurements;
import model.TodaysMeasurements;
import model.CalorieTracker;
import persistence.Reader;
import persistence.Writer;
import ui.tools.AnalyzeMeasurements;
import ui.tools.MaintenanceCalories;
import ui.tools.TrackCalories;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//Represents the Health & Fitness application.
public class FitnessApp extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/ListOfMeasurements.json";
    private ListOfMeasurements listOfMeasurements;
    private CalorieTracker trackCaloriesConsumed;
    JPanel panel = new JPanel();
    private Scanner input;
    private Writer writer;
    private Reader reader;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;

    // EFFECTS: constructs List Of Measurements and runs the Health & Fitness application
    public FitnessApp() throws FileNotFoundException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Health &Fitness Application");
        pack();
        setVisible(true);
        panel.setLayout(null);
        add(panel);
        setSize(500, 500);
        input = new Scanner(System.in);
        listOfMeasurements = new ListOfMeasurements();
        writer = new Writer(JSON_STORE);
        reader = new Reader(JSON_STORE);
        runCalorie();
    }

    /*
     *MODIFIES: this
     *EFFECTS: processes user input
     */
    private void runCalorie() {
        boolean continueApplication = true;
        String command;

        initialize();

        while (continueApplication) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                continueApplication = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGood job tracking today! \nHope to see you again tomorrow!"
                + " \nRemember, your health is an investment, not an experience!");

    }

    /*
     *MODIFIES: this
     *EFFECTS: processes user command
     */
    private void processCommand(String command) {
        if (command.equals("t")) {
            trackCalories();
        } else if (command.equals("c")) {
            calculateMaintenance();
        } else if (command.equals("m")) {
            inputMeasurements();
        } else if (command.equals("v")) {
            viewListOfMeasurements();
        } else if (command.equals("r")) {
            resetCalories();
        } else if (command.equals("s")) {
            saveListOfMeasurements();
        } else if (command.equals("l")) {
            loadListOfMeasurements();
        } else {
            System.out.println("Please select a valid option!");
        }
    }

    /*
     *EFFECTS: Initializes the list of Measurements and the Calorie tracker
     */
    private void initialize() {
        listOfMeasurements = new ListOfMeasurements();
        trackCaloriesConsumed = new CalorieTracker();
        input = new Scanner(System.in);
    }

    /*
     *EFFECTS: displays menu of options to user
     */
    public void displayMenu() {
        btn1 = new JButton("Track Calories");
        btn2 = new JButton("Analyze Measurements");
        btn3 = new JButton("Calculate Maintenance Calories");
        btn4 = new JButton("Quit The Application");
        btn1.setBounds(200, 200, 300, 100);
        btn2.setBounds(200, 300, 300, 100);
        btn3.setBounds(200, 400, 300, 100);
        btn4.setBounds(200, 500, 300, 100);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
    }

    /*
     *MODIFIES: this
     *EFFECTS: tracks the calories for a particular meal and adds it to the total calories consumed
     */
    public void trackCalories() {
        System.out.println("Enter total calories consumed in this meal");
        double totalCalories = input.nextDouble();
        trackCaloriesConsumed.addCalories(totalCalories);
        System.out.println("Total CaloriesConsumed:" + trackCaloriesConsumed.getTotalCaloriesConsumed());
        if (totalCalories < 0.0) {
            System.out.println("Cannot track negative calories...\n");
        }

    }

    /*
     *MODIFIES: this
     *EFFECTS: calculates the user's maintenance calories (i.e, Basal Metabolic Rate)
     */
    public void calculateMaintenance() {
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("Enter your Gender(m - for Male and f- for Female)");
        String gender = input.next();
        System.out.println("Enter your Height(in cm)");
        double height = input.nextDouble();
        System.out.println("Enter your Body Weight(in kg)");
        double weight = input.nextDouble();
        UserMaintenanceCalories newMaintenance = new UserMaintenanceCalories(age, height, weight, gender);
        System.out.printf("Total Calories required per "
                + "day to maintain your body weight: %.2f\n", newMaintenance.calculateMaintenance());
    }

    /*
     *MODIFIES: this
     *EFFECTS: accepts the user's body measurements for the day and adds it to the list of measurements
     */
    public void inputMeasurements() {
        System.out.println("What was your body weight today?");
        float weight = input.nextFloat();
        System.out.println("What was your waist measurement today?(in inches)");
        float waist = input.nextFloat();
        System.out.println("What was your chest measurement today?(in inches)");
        float chest = input.nextFloat();
        System.out.println("What was your shoulder measurement today?(in inches)");
        float shoulder = input.nextFloat();
        TodaysMeasurements newMeasurements = new TodaysMeasurements(weight, waist, shoulder, chest);
        listOfMeasurements.addNewMeasurements(newMeasurements);
        System.out.println("Good job tracking today! \nMeasurements were successfully recorded");
    }

    /*
     *EFFECTS: displays the list of daily measurements made
     */
    public void viewListOfMeasurements() {
        System.out.println("List of Measurements:" + listOfMeasurements.viewListOfMeasurements());

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
     *MODIFIES: this
     *EFFECTS: sets the tracked calories to 0
     */
    public void resetCalories() {
        trackCaloriesConsumed.resetCalories();
        System.out.println("Total calories have been reset!");
    }

    // EFFECTS: saves the List of Measurements to file
    public void saveListOfMeasurements() {
        try {
            writer.open();
            writer.write(listOfMeasurements);
            writer.close();
            System.out.println("Saved your List of Measurements to:" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads List of Measurements from file
    public void loadListOfMeasurements() {
        try {
            listOfMeasurements = reader.read();
            System.out.println("Loaded your previously made List of Measurements from:" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            playSound("./data/StarWars3.wav");
            new TrackCalories();
        } else if (e.getSource() == btn2) {
            playSound("./data/StarWars3.wav");
            try {
                new AnalyzeMeasurements();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (e.getSource() == btn3) {
            playSound("./data/StarWars3.wav");
            new MaintenanceCalories();

        } else if (e.getSource() == btn4) {
            System.exit(0);

        }
    }
}


