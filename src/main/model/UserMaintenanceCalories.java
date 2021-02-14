package model;

//Represents the information required to calculate the user's Maintenance Calories(i.e., Basal Metabolic Rate).
public class UserMaintenanceCalories {

    private final double height;     //height of the calorie tracking individual in cm
    private final double bodyWeight;     //weight of the calorie tracking individual in kg
    private final int age;           //age of the calorie tracking individual in years
    private final String gender;        //gender of the calorie tracking individual
    private double maintenanceCalories;     //MaintenanceCalories of the calorie tracking individual

    /*
     * REQUIRES: userAge, userHeight and userWeight is non-negative.
     * EFFECTS: age of User is set to userAge, weight is set to userWeight, height is set to userHeight and
     * gender is set to userGender.
     */
    public UserMaintenanceCalories(int userAge, double userHeight, double userWeight, String userGender) {
        this.height = userHeight;
        this.age = userAge;
        this.bodyWeight = userWeight;
        this.gender = userGender;

    }

    /*
     * MODIFIES: this
     * EFFECTS: if gender is male("m"), Maintenance calories is calculated using the Harris-Benedict equation for men,
     * else if gender is female("f"), Maintenance calories is calculated using the Harris-Benedict equation for women,
     * otherwise Maintenance calories is set to 0
     */
    public double calculateMaintenance() {
        if (this.gender.equals("m")) {
            maintenanceCalories = 88.362 + (13.397 * bodyWeight) + (4.799 * height) - (4.33 * age);
        } else if (this.gender.equals("f")) {
            maintenanceCalories = 447.593 + (9.247 * bodyWeight) + (3.098 * height) - (4.33 * age);
        } else {
            maintenanceCalories = 0;
        }
        return maintenanceCalories;
    }

}
