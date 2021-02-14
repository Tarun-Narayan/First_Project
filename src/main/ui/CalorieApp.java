package ui;

import model.MaintenanceCalories;
import model.ListOfMeasurements;
import model.TodaysMeasurements;
import model.TrackCalories;

import java.util.Scanner;

public class CalorieApp {
    private TodaysMeasurements newMeasurements;
    private ListOfMeasurements listOfMeasurements;
    private MaintenanceCalories newMaintenance;
    private TrackCalories trackCaloriesConsumed;
    private Scanner input;


    // EFFECTS: runs the calorie application
    public CalorieApp() {
        runCalorie();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCalorie() {
        boolean continueApplication = true;
        String command = null;

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
                + " \nYour health is an investment, not an experience!");

    }

    private void processCommand(String command) {
        if (command.equals("t")) {
            trackCalories();
        } else if (command.equals("c")) {
            calculateMaintenance();
        } else if (command.equals("m")) {
            inputMeasurements();
        } else if (command.equals("v")) {
            viewListOfMeasurements();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void initialize() {
        listOfMeasurements = new ListOfMeasurements();
        trackCaloriesConsumed = new TrackCalories();
        input = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("\nHi there! What would you like to do today?:");
        System.out.println("\tt -> Track Calories");
        System.out.println("\tc -> Calculate your Maintenance Calories");
        System.out.println("\tm -> Record today's body measurements");
        System.out.println("\tv -> View a list of all your previously made measurements");
        System.out.println("\tq -> quit");
    }

    private void trackCalories() {
        System.out.println("Enter total calories consumed in this meal");
        double totalCalories = input.nextDouble();
        trackCaloriesConsumed.addCalories(totalCalories);
        System.out.println("Total CaloriesConsumed:" + trackCaloriesConsumed.getTotalCaloriesConsumed());
        if (totalCalories < 0.0) {
            System.out.println("Cannot track negative calories...\n");
        }

    }

    private void calculateMaintenance() {
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("Enter your Gender(m - for Male and f- for Female)");
        String gender = input.nextLine();
        System.out.println("Enter your Height(in cm)");
        double height = input.nextDouble();
        System.out.println("Enter your Body Weight(in kg)");
        double weight = input.nextDouble();
        newMaintenance = new MaintenanceCalories(age, height, weight, gender);
        System.out.println("Total Calories required per day to maintain your body weight:"
                + newMaintenance.calculateMaintenance());
    }

    private void inputMeasurements() {
        System.out.println("What was your body weight today?");
        double weight = input.nextDouble();
        System.out.println("What was your waist measurement today?(in inches)");
        float waist = input.nextFloat();
        System.out.println("What was your chest measurement today?(in inches)");
        float chest = input.nextFloat();
        System.out.println("What was your shoulder measurement today?(in inches)");
        float shoulder = input.nextFloat();
        newMeasurements = new TodaysMeasurements(weight, waist, shoulder, chest);
        listOfMeasurements.addNewMeasurements(newMeasurements);
        System.out.println("Good job tracking today! \nMeasurements were successfully recorded");
    }

    private ListOfMeasurements viewListOfMeasurements() {
        return listOfMeasurements;

    }

}
