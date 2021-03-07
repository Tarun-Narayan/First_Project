package ui;

import model.UserMaintenanceCalories;
import model.ListOfMeasurements;
import model.TodaysMeasurements;
import model.CalorieTracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//Represents the Health & Fitness application.
public class FitnessApp {
    private static final String JSON_STORE = "./data/workroom.json";
    private ListOfMeasurements listOfMeasurements;
    private CalorieTracker trackCaloriesConsumed;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs List Of Measurements and runs the Health & Fitness application
    public FitnessApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        listOfMeasurements = new ListOfMeasurements();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
    private void displayMenu() {
        System.out.println("\nHi there! What would you like to do today?:");
        System.out.println("\tt -> Track Calories");
        System.out.println("\tc -> Calculate your Maintenance Calories");
        System.out.println("\tm -> Record today's body measurements");
        System.out.println("\tv -> View a list of all measurements");
        System.out.println("\ts -> Save the list of measurements made today");
        System.out.println("\tl -> Load all your previously made measurements");
        System.out.println("\tr -> Reset tracked Calories");
        System.out.println("\tq -> quit");
    }

    /*
     *MODIFIES: this
     *EFFECTS: tracks the calories for a particular meal and adds it to the total calories consumed
     */
    private void trackCalories() {
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
    private void calculateMaintenance() {
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
    private void inputMeasurements() {
        System.out.println("What was your body weight today?");
        double weight = input.nextDouble();
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
    private void viewListOfMeasurements() {
        System.out.println("List of Measurements:" + listOfMeasurements.viewListOfMeasurements());

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
    private void saveListOfMeasurements() {
        try {
            jsonWriter.open();
            jsonWriter.write(listOfMeasurements);
            jsonWriter.close();
            System.out.println("Saved your List of Measurements to:" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads List of Measurements from file
    private void loadListOfMeasurements() {
        try {
            listOfMeasurements = jsonReader.read();
            System.out.println("Loaded your previously made List of Measurements from:" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}


