package model;

import java.util.LinkedList;
import java.util.List;


public class ListOfMeasurements {
    private LinkedList<TodaysMeasurements> listOfMeasurements;

    public ListOfMeasurements() {
        listOfMeasurements = new LinkedList<>();
    }

    public void addNewMeasurements(TodaysMeasurements newMeasurements) {
        this.listOfMeasurements.add(newMeasurements);
    }

    public String viewListOfMeasurements() {
        String list = "";
        for (TodaysMeasurements measurement : listOfMeasurements) {
            list = list + "\nMeasurement" + (listOfMeasurements.indexOf(measurement) + 1)
                    + ":" + "\n Weight:" + measurement.getWeight() + "\n Waist:" + measurement.getWaist()
                    + "\n Shoulders:" + measurement.getShoulders() + "\n Chest:" + measurement.getChest();
        }
        return list;
    }

    public TodaysMeasurements getLatestMeasurements() {
        return listOfMeasurements.pollFirst();

    }
}
