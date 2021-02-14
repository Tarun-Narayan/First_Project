package model;

// Represents Today's measurements - containing user's body weight, waist size, shoulder width and chest size.
public class TodaysMeasurements {
    private double bodyWeight;
    private float waist;
    private float shoulders;
    private float chest;

    /*
     *REQUIRES: weight, waist, shoulders and chest measurements are non-negative
     *EFFECTS: Today's Measurements has given weight(in kg), waist(in inches), shoulders(in inches) and chest(in inches)
     * measurements
     */
    public TodaysMeasurements(double weight, float waist, float shoulders, float chest) {
        this.bodyWeight = weight;
        this.waist = waist;
        this.shoulders = shoulders;
        this.chest = chest;
    }

    /*
     *EFFECTS: Returns the body weight of Today's Measurements
     */
    public double getWeight() {
        return this.bodyWeight;
    }

    /*
     *EFFECTS: Returns the waist measurement of Today's Measurements
     */
    public double getWaist() {
        return this.waist;
    }

    /*
     *EFFECTS: Returns the shoulder measurement of Today's Measurements
     */
    public double getShoulders() {
        return this.shoulders;
    }

    /*
     *EFFECTS: Returns the chest measurement of Today's Measurements
     */
    public double getChest() {
        return this.chest;
    }
}
