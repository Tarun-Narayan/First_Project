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

    public TodaysMeasurements getLatestMeasurements() {
        return listOfMeasurements.pollFirst();

    }
}
