package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieAppTest {
    private ListOfMeasurements testList;
    private MaintenanceCalories testDatabase1;
    private MaintenanceCalories testDatabase2;
    private TrackCalories testTracker;


    @BeforeEach
    public void setup() {
        testList = new ListOfMeasurements();
        testTracker = new TrackCalories();
        testDatabase1 = new MaintenanceCalories(18, 180,65,"m");
        testDatabase2 = new MaintenanceCalories(20, 176,63,"f");
    }
    @Test
    void testMaintenanceCaloriesMale(){
        assertEquals(1745.047, testDatabase1.calculateMaintenance());

    }
    @Test
    void testMaintenanceCaloriesFemale(){
        assertEquals(1488.8020000000001, testDatabase2.calculateMaintenance());

    }
    @Test
    void testAddCaloriesForNewDatabase(){
        testTracker.addCalories(415);
        assertEquals(415, testTracker.getTotalCaloriesConsumed());

    }
    @Test
    void testAddCaloriesForUsedDatabase(){
        testTracker.addCalories(415);
        testTracker.addCalories(680);
        assertEquals(1095, testTracker.getTotalCaloriesConsumed());

    }
    @Test
    void testResetCalories(){
        testTracker.addCalories(415);
        assertEquals(415, testTracker.getTotalCaloriesConsumed());
        testTracker.resetCalories();
        assertEquals(0, testTracker.getTotalCaloriesConsumed());

    }
    @Test
    void testAddNewMeasurementsToEmptyList(){
        TodaysMeasurements measurements = new TodaysMeasurements(70,32,45,40);
        testList.addNewMeasurements(measurements);
        assertEquals(measurements,testList.getLatestMeasurements());
    }


}
