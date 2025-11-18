import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityStudentTest {

    private double[][] sampleArray = {
        {1, 2, 3},
        {4, 5},
        {6, 7, 8, 9}
    };

    @Test
    public void testGetTotal() {
        assertEquals(45, TwoDimRaggedArrayUtility.getTotal(sampleArray), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(45.0 / 9, TwoDimRaggedArrayUtility.getAverage(sampleArray), 0.001);
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(sampleArray, 0), 0.001);
        assertEquals(9, TwoDimRaggedArrayUtility.getRowTotal(sampleArray, 1), 0.001);
        assertEquals(30, TwoDimRaggedArrayUtility.getRowTotal(sampleArray, 2), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(sampleArray, 0), 0.001);
        assertEquals(14, TwoDimRaggedArrayUtility.getColumnTotal(sampleArray, 1), 0.001);
        assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(sampleArray, 2), 0.001);
        assertEquals(9, TwoDimRaggedArrayUtility.getColumnTotal(sampleArray, 3), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(sampleArray, 0), 0.001);
        assertEquals(5, TwoDimRaggedArrayUtility.getHighestInRow(sampleArray, 1), 0.001);
        assertEquals(9, TwoDimRaggedArrayUtility.getHighestInRow(sampleArray, 2), 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(sampleArray, 0), 0.001);
        assertEquals(4, TwoDimRaggedArrayUtility.getLowestInRow(sampleArray, 1), 0.001);
        assertEquals(6, TwoDimRaggedArrayUtility.getLowestInRow(sampleArray, 2), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9, TwoDimRaggedArrayUtility.getHighestInArray(sampleArray), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(sampleArray), 0.001);
    }

    @Test
    public void testReadAndWriteFile() throws IOException {
        File tempFile = new File("testFile.txt");
        TwoDimRaggedArrayUtility.writeToFile(sampleArray, tempFile);
        double[][] readArray = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertArrayEquals(sampleArray, readArray);
        tempFile.delete();
    }
}