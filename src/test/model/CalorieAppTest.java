package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieAppTest {
    private ListOfMeasurements testList;
    private TodaysMeals testMeals;
    private UserMaintenanceCalories testDatabase1;
    private UserMaintenanceCalories testDatabase2;
    private UserMaintenanceCalories testDatabase3;
    private CalorieTracker testTracker;


    @BeforeEach
    public void setup() {
        testList = new ListOfMeasurements();
        testTracker = new CalorieTracker();
        testMeals = new TodaysMeals();
        testDatabase1 = new UserMaintenanceCalories(18, 180,65,"m");
        testDatabase2 = new UserMaintenanceCalories(20, 170,65,"f");
        testDatabase3 = new UserMaintenanceCalories(20, 170,65,"g");
    }
    @Test
    void testMaintenanceCaloriesMale(){
        assertEquals(1745.047, testDatabase1.calculateMaintenance());

    }
    @Test
    void testMaintenanceCaloriesFemale(){
        assertEquals(1488.708, testDatabase2.calculateMaintenance());

    }
    @Test
    void testMaintenanceCaloriesIncorrectGender(){
        assertEquals(0, testDatabase3.calculateMaintenance());

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
    @Test
    void testRetrieveValidMeasurementFromList(){
        TodaysMeasurements measurements1 = new TodaysMeasurements(70,32,45,40);
        testList.addNewMeasurements(measurements1);
        TodaysMeasurements measurements2 = new TodaysMeasurements(68,31,47,39);
        testList.addNewMeasurements(measurements2);
        TodaysMeasurements measurements3 = new TodaysMeasurements(65,30,49,37);
        testList.addNewMeasurements(measurements3);
        assertEquals("\n Body Weight:" + 68.0 + " Kg" + "\n Waist:" + 31.0
                + " inches" + "\n Shoulders:" + 47.0 + " inches"
                + "\n Chest:" + 39.0 + " inches", testList.retrieveMeasurement(68));

    }
    @Test
    void testRetrieveInvalidMeasurementFromList(){
        TodaysMeasurements measurements1 = new TodaysMeasurements(70,32,45,40);
        testList.addNewMeasurements(measurements1);
        TodaysMeasurements measurements2 = new TodaysMeasurements(69,31,47,39);
        testList.addNewMeasurements(measurements2);
        TodaysMeasurements measurements3 = new TodaysMeasurements(65,30,49,37);
        testList.addNewMeasurements(measurements3);
        assertEquals("Invalid weight!", testList.retrieveMeasurement(68));

    }
    @Test
    void testAddNewMeasurementsToNonEmptyList(){
        TodaysMeasurements measurements1 = new TodaysMeasurements(70,32,45,40);
        testList.addNewMeasurements(measurements1);
        TodaysMeasurements measurements2 = new TodaysMeasurements(70,32,45,40);
        testList.addNewMeasurements(measurements2);
        assertEquals(measurements2,testList.getLatestMeasurements());
    }
    @Test
    void testViewNonEmptyListOfMeasurements(){
        TodaysMeasurements measurements1 = new TodaysMeasurements(57,32,45,40);
        testList.addNewMeasurements(measurements1);
        TodaysMeasurements measurements2 = new TodaysMeasurements(73,31,43,39);
        testList.addNewMeasurements(measurements2);
        assertEquals("\nMeasurement1:\n" +
                " Body Weight:57.0 Kg\n" +
                " Waist:32.0 inches\n" +
                " Shoulders:45.0 inches\n" +
                " Chest:40.0 inches\n" +
                "Measurement2:\n" +
                " Body Weight:73.0 Kg\n" +
                " Waist:31.0 inches\n" +
                " Shoulders:43.0 inches\n" +
                " Chest:39.0 inches",testList.viewListOfMeasurements());
    }
    @Test
    void testViewEmptyListOfMeasurements(){
        assertEquals("",testList.viewListOfMeasurements());
    }
    @Test
    void testAddNewMealToEmptyTodaysMeals(){
        testMeals.addMeal("Oatmeal", 23);
        assertEquals("Preparation Time for meal: 23 minutes", testMeals.getPrepTime("Oatmeal"));
    }
    @Test
    void testAddNewMealToNonEmptyTodaysMeals(){
        testMeals.addMeal("Oatmeal", 23);
        testMeals.addMeal("French Toast", 26);
        assertEquals("Preparation Time for meal: 26 minutes",testMeals.getPrepTime("French Toast"));
    }
    @Test
    void testRemoveValidMealFromTodaysMeals(){
        testMeals.addMeal("Oatmeal", 23);
        testMeals.addMeal("French Toast", 26);
        assertEquals("Meal removed!",testMeals.removeMeal("Oatmeal"));
        testMeals.removeMeal("Oatmeal");
        assertEquals("\n1. French Toast",testMeals.viewTodaysMeals());
    }
    @Test
    void testRemoveInvalidMealFromTodaysMeals(){
        testMeals.addMeal("Oatmeal", 23);
        testMeals.addMeal("French Toast", 26);
        assertEquals("Invalid meal!",testMeals.removeMeal("Pancake"));
        assertEquals("\n1. French Toast\n" +
                "2. Oatmeal",testMeals.viewTodaysMeals());
    }
    @Test
    void testViewNonEmptyTodaysMeals(){
        testMeals.addMeal("Oatmeal", 23);
        testMeals.addMeal("French Toast", 26);
        assertEquals("\n1. French Toast\n" +
                "2. Oatmeal",testMeals.viewTodaysMeals());
    }
    @Test
    void testViewEmptyTodaysMeals(){
        assertEquals("", testMeals.viewTodaysMeals());
    }


}
