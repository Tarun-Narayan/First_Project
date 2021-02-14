package model;

public class TrackCalories {
    private double totalCaloriesConsumed;        //Total calories consumed by the calorie tracking individual

    public TrackCalories() {
        this.totalCaloriesConsumed = 0;
    }

    public void addCalories(double calories) {
        totalCaloriesConsumed = totalCaloriesConsumed + calories;
    }

    public double getTotalCaloriesConsumed() {
        return this.totalCaloriesConsumed;
    }

    public void resetCalories() {
        totalCaloriesConsumed = 0;
    }
}
