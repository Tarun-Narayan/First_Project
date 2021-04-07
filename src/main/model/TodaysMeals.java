package model;

import java.util.HashMap;
import java.util.Map;

//Represents a hashmap of user's meals for the day.
public class TodaysMeals {
    Map<String, Integer> meals; //Represents a map of today's meals

    /*
     * EFFECTS: initializes each newly created meals as an empty hashmap
     */
    public TodaysMeals() {
        meals = new HashMap<>();
    }

    /*
     * MODIFIES: this
     * EFFECTS: adds new Meal to the hashmap
     */
    public void addMeal(String name, int prepTime) {
        meals.put(name, prepTime);
    }

    /*
     * EFFECTS: Displays a list of today's meals
     */
    public String viewTodaysMeals() {
        String result = "";
        int val = 1;
        for (String key : meals.keySet()) {
            result = result + "\n" + val + ". " + key;
            val++;
        }
        return result;

    }

    /*
     * MODIFIES: this
     * EFFECTS: removes specified Meal from the hashmap
     */
    public String removeMeal(String name) {
        String result = "Invalid meal!";
        if (meals.containsKey(name)) {
            meals.remove(name);
            result = "Meal removed!";
        }
        return result;
    }

    /*
     * EFFECTS: returns the preparation time for the given meal
     */
    public String getPrepTime(String name) {
        try {
            int result = 0;
            result = meals.get(name);
            return "Preparation Time for meal: " + result + " minutes";
        } catch (NullPointerException e) {
            String result1 = "Invalid Meal!";
            return result1;
        }
    }

}
