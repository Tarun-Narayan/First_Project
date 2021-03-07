package persistence;

import model.TodaysMeasurements;
import model.ListOfMeasurements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest extends JsonTest{
    @Test
    void testReaderNonExistentFile() {
        Reader reader = new Reader("./data/noSuchFile.json");
        try {
            ListOfMeasurements lom = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyListOfMeasurements() {
        Reader reader = new Reader("./data/testReaderEmptyListOfMeasurements.json");
        try {
            ListOfMeasurements lom = reader.read();
            assertEquals(0, lom.numMeasurements());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralListOfMeasurements() {
        Reader reader = new Reader("./data/testReaderGeneralListOfMeasurements.json");
        try {
            ListOfMeasurements lom = reader.read();
            List<TodaysMeasurements> newMeasurements = lom.getTodaysMeasurements();
            assertEquals(2, newMeasurements.size());
            checkTodaysMeasurements(65, 32, 45, 42, newMeasurements.get(0));
            checkTodaysMeasurements(66, 31, 44, 43, newMeasurements.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
