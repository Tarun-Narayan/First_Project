package model;

import java.util.LinkedList;
import java.util.List;

public class ListOfWeights {
    private List<TodaysWeight> list = new LinkedList<>();

    public void addNewWeight(int newWeight) {
        this.list.add(new TodaysWeight(newWeight));
    }
}
