package persistence;

import model.TodaysMeasurements;
import model.ListOfMeasurements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class WriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            ListOfMeasurements lom = new ListOfMeasurements();
            Writer writer = new Writer("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListOfMeasurements() {
        try {
            ListOfMeasurements lom = new ListOfMeasurements();
            Writer writer = new Writer("./data/testWriterEmptyListOfMeasurements.json");
            writer.open();
            writer.write(lom);
            writer.close();

            Reader reader = new Reader("./data/testWriterEmptyListOfMeasurements.json");
            lom = reader.read();
            assertEquals(0, lom.numMeasurements());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralListOfMeasurements() {
        try {
            ListOfMeasurements lom = new ListOfMeasurements();
            lom.addNewMeasurements(new TodaysMeasurements(65, 32, 45, 42));
            lom.addNewMeasurements(new TodaysMeasurements(66, 31, 44, 43));
            Writer writer = new Writer("./data/testWriterGeneralListOfMeasurements.json");
            writer.open();
            writer.write(lom);
            writer.close();

            Reader reader = new Reader("./data/testWriterGeneralListOfMeasurements.json");
            lom = reader.read();
            List<TodaysMeasurements> newMeasurements = lom.getTodaysMeasurements();
            assertEquals(2, newMeasurements.size());
            checkTodaysMeasurements(65, 32, 45, 42, newMeasurements.get(0));
            checkTodaysMeasurements(66, 31, 44, 43, newMeasurements.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
