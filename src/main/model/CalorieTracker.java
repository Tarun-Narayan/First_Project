package model;

//Represents the Calorie tracking functionality of the application.
public class CalorieTracker {
    private double totalCaloriesConsumed;        //Total calories consumed by the calorie tracking individual


    /*
     * EFFECTS: Total Calories consumed on a new CalorieTracker is set to 0
     */
    public CalorieTracker() {
        this.totalCaloriesConsumed = 0;
    }

    /*
     * REQUIRES: totalCaloriesConsumed is non-negative
     * MODIFIES: this
     * EFFECTS: calories are added to totalCaloriesConsumed and
     * the updated totalCaloriesConsumed is returned
     */
    public void addCalories(double calories) {
        totalCaloriesConsumed = totalCaloriesConsumed + calories;
    }

    /*
     * EFFECTS: Returns the Total Calories consumed
     */
    public double getTotalCaloriesConsumed() {
        return this.totalCaloriesConsumed;
    }

    /*
     * MODIFIES: this
     * EFFECTS: Total Calories consumed is set to 0
     */
    public void resetCalories() {
        totalCaloriesConsumed = 0;
    }
}
