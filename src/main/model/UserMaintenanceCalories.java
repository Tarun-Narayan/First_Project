package model;

//Represents the information required to calculate the user's Maintenance Calories(i.e., Basal Metabolic Rate).
public class UserMaintenanceCalories {

    private final double height;     //height of the calorie tracking individual in cm
    private final double bodyWeight;     //weight of the calorie tracking individual in kg
    private final int age;           //age of the calorie tracking individual in years
    private final String gender;        //gender of the calorie tracking individual
    private double maintenanceCalories;     //MaintenanceCalories of the calorie tracking individual
    static final double maleAddend = 88.362; //Number required to be added to other measurements to calculate
    //maintenance in men.
    static final double femaleAddend = 447.593; //Number required to be added to other measurements to calculate
    //maintenance in women.
    static final double maleBodyWeightMultiplier = 13.397; //Number multiplied to a male user's body weight
    static final double femaleBodyWeightMultiplier = 9.247; //Number multiplied to a female user's body weight
    static final double maleHeightMultiplier = 4.799; //Number multiplied to a male user's height
    static final double femaleHeightMultiplier = 3.098; //Number multiplied to a female user's height
    static final double ageMultiplier = 4.33; //Number multiplied to a user's age

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
            maintenanceCalories = maleAddend + (maleBodyWeightMultiplier * bodyWeight)
                    + (maleHeightMultiplier * height) - (ageMultiplier * age);
        } else if (this.gender.equals("f")) {
            maintenanceCalories = femaleAddend + (femaleBodyWeightMultiplier * bodyWeight)
                    + (femaleHeightMultiplier * height) - (ageMultiplier * age);
        } else {
            maintenanceCalories = 0;
        }
        return maintenanceCalories;
    }

}
