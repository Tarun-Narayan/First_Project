package ui;

import java.io.FileNotFoundException;

//Represents the Main class, used to run the application
public class Main {
    public static void main(String[] args) {
        try {
            new FitnessApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: The file could not be found");
        }
    }
}
