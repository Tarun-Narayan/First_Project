package persistence;


import model.ListOfMeasurements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.TodaysMeasurements;
import org.json.*;

/* Represents a reader that reads List of Measurements from JSON data stored in file
 * Citation: Code obtained and modified from JsonSerializationDemo
 * URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git
 */

public class Reader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public Reader(String source) {
        this.source = source;
    }

    // EFFECTS: reads List of Measurements from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfMeasurements read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfMeasurements(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses List of Measurements from JSON object and returns it
    private ListOfMeasurements parseListOfMeasurements(JSONObject jsonObject) {
        ListOfMeasurements lom = new ListOfMeasurements();
        addMeasurements(lom, jsonObject);
        return lom;
    }

    // MODIFIES: lom
    // EFFECTS: parses Measurements from JSON object and adds them to workroom
    private void addMeasurements(ListOfMeasurements lom, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("measurements");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addMeasurement(lom, nextThingy);
        }
    }

    // MODIFIES: lom
    // EFFECTS: parses Today's Measurement from JSON object and adds it to List of Measurements
    private void addMeasurement(ListOfMeasurements lom, JSONObject jsonObject) {
        double weight = jsonObject.getFloat("weight");
        float waist = jsonObject.getFloat("waist");
        float shoulders = jsonObject.getFloat("shoulders");
        float chest = jsonObject.getFloat("chest");
        TodaysMeasurements newMeasurements = new TodaysMeasurements(weight, waist, shoulders, chest);
        lom.addNewMeasurements(newMeasurements);
    }
}
