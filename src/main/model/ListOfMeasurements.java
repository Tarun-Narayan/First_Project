package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.LinkedList;

//Represents a list of your previously made body measurements.
public class ListOfMeasurements implements Writable {
    private LinkedList<TodaysMeasurements> listOfMeasurements;  //Represents a list of measurements

    /*
     * EFFECTS: initializes each newly created listOfMeasurements as an empty list
     */
    public ListOfMeasurements() {
        listOfMeasurements = new LinkedList<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds new Measurement to the end of the list
     */
    public void addNewMeasurements(TodaysMeasurements newMeasurements) {
        this.listOfMeasurements.add(newMeasurements);
    }

    /*
     * EFFECTS: Displays a list of all Measurements made
     */
    public String viewListOfMeasurements() {
        StringBuilder list = new StringBuilder();
        for (TodaysMeasurements measurement : listOfMeasurements) {
            list = list.append("\nMeasurement" + (listOfMeasurements.indexOf(measurement) + 1)
                    + ":" + "\n Body Weight:" + measurement.getWeight() + " Kg" + "\n Waist:" + measurement.getWaist()
                    + " inches" + "\n Shoulders:" + measurement.getShoulders() + " inches"
                    + "\n Chest:" + measurement.getChest() + " inches");
        }
        return list.toString();
    }

    /*
     * EFFECTS: returns the last measurement made/added to the list
     */
    public TodaysMeasurements getLatestMeasurements() {
        return listOfMeasurements.pollLast();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("measurements", measurementsToJson());
        return json;
    }

    // EFFECTS: returns Today's measurements in this List of Measurements as a JSON array
    private JSONArray measurementsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (TodaysMeasurements tm : listOfMeasurements) {
            jsonArray.put(tm.toJson());
        }

        return jsonArray;
    }
}
