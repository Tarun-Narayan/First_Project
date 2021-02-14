package model;

public class MaintenanceCalories {

    private double height;     //height of the calorie tracking individual in cm
    private double bodyWeight;     //weight of the calorie tracking individual in kg
    private int age;           //age of the calorie tracking individual in years
    private String gender;        //gender of the calorie tracking individual
    private double maintenanceCalories;     //MaintenanceCalories of the calorie tracking individual

    public MaintenanceCalories(int userAge, double userHeight, double userWeight, String userGender) {
        this.height = userHeight;
        this.age = userAge;
        this.bodyWeight = userWeight;
        this.gender = userGender;

    }

    public double calculateMaintenance() {
        if (this.gender.equals("m")) {
            maintenanceCalories = 88.362 + (13.397 * bodyWeight) + (4.799 * height) - (4.33 * age);
        } else if (this.gender.equals("f")) {
            maintenanceCalories = 447.593 + (9.247 * bodyWeight) + (3.098 * height) - (4.33 * age);
        }
        return maintenanceCalories;
    }

}
