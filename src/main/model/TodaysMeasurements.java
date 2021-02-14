package model;

// Represents Today's measurements having your body weight,your waist size, your shoulder width and your chest size.
public class TodaysMeasurements {
    private double bodyWeight;
    private float waist;
    private float shoulders;
    private float chest;

    // EFFECTS: TodaysMeasurements has given body weight, waist size, shoulder width and chest size.
    public TodaysMeasurements(double weight, float waist, float shoulders, float chest) {
        this.bodyWeight = weight;
        this.waist = waist;
        this.shoulders = shoulders;
        this.chest = chest;
    }

    public double getWeight() {
        return this.bodyWeight;
    }

    public double getWaist() {
        return this.waist;
    }

    public double getShoulders() {
        return this.shoulders;
    }

    public double getChest() {
        return this.chest;
    }
}
