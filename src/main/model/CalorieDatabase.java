package model;

public class CalorieDatabase {

    private double height;     //height of the calorie tracking individual in cm
    private double weight;     //weight of the calorie tracking individual in kg
    private int age;           //age of the calorie tracking individual in years
    private String gender;        //gender of the calorie tracking individual
    private double maintenanceCalories;     //MaintenanceCalories of the calorie tracking individual
    private double totalCaloriesConsumed;        //Total calories consumed by the calorie tracking individual

    public double calculateMaintenance() {
        if (gender.equals("m")) {
            maintenanceCalories = 88.362 + (13.397 * weight) + (4.799 * height) - (4.33 * age);
        } else if (gender.equals("f")) {
            maintenanceCalories = 447.593 + (9.247 * weight) + (3.098 * height) - (4.33 * age);
        }
        return maintenanceCalories;
    }

    public double addCalories(double calories) {
        totalCaloriesConsumed = totalCaloriesConsumed + calories;
        return totalCaloriesConsumed;
    }

    public double resetCalories() {
        totalCaloriesConsumed = 0;
        return totalCaloriesConsumed;
    }

}
