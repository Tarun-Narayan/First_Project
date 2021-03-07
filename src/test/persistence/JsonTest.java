package persistence;


import model.TodaysMeasurements;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTodaysMeasurements(double weight, float waist, float shoulders, float chest,
                                           TodaysMeasurements measurements) {
        assertEquals(weight, measurements.getWeight());
        assertEquals(waist, measurements.getWaist());
        assertEquals(chest, measurements.getChest());
        assertEquals(shoulders, measurements.getShoulders());
    }
}
