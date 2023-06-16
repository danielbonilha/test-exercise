package test.bysix;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ExerciseOneTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintNumbersWithMax15() {
        String expectedOutput = "1\n" +
                "2\n" +
                "Visual\n" +
                "4\n" +
                "Nuts\n" +
                "Visual\n" +
                "7\n" +
                "8\n" +
                "Visual\n" +
                "Nuts\n" +
                "11\n" +
                "Visual\n" +
                "13\n" +
                "14\n" +
                "Visual Nuts\n";
        ExerciseOne.printNumbers(15);
        assertEquals(expectedOutput, getConsoleOutput());
    }

    @Test
    public void testPrintNumbersWithMax50() {
        String expectedOutput = "1\n" +
                "2\n" +
                "Visual\n" +
                "4\n" +
                "Nuts\n" +
                "Visual\n" +
                "7\n" +
                "8\n" +
                "Visual\n" +
                "Nuts\n" +
                "11\n" +
                "Visual\n" +
                "13\n" +
                "14\n" +
                "Visual Nuts\n" +
                "16\n" +
                "17\n" +
                "Visual\n" +
                "19\n" +
                "Nuts\n" +
                "Visual\n" +
                "22\n" +
                "23\n" +
                "Visual\n" +
                "Nuts\n" +
                "26\n" +
                "Visual\n" +
                "28\n" +
                "29\n" +
                "Visual Nuts\n" +
                "31\n" +
                "32\n" +
                "Visual\n" +
                "34\n" +
                "Nuts\n" +
                "Visual\n" +
                "37\n" +
                "38\n" +
                "Visual\n" +
                "Nuts\n" +
                "41\n" +
                "Visual\n" +
                "43\n" +
                "44\n" +
                "Visual Nuts\n" +
                "46\n" +
                "47\n" +
                "Visual\n" +
                "49\n" +
                "Nuts\n";
        ExerciseOne.printNumbers(50);
        assertEquals(expectedOutput, getConsoleOutput());
    }

    @Test
    public void testPrintNumbersWithMax0() {
        String expectedOutput = "";
        ExerciseOne.printNumbers(0);
        assertEquals(expectedOutput, getConsoleOutput());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintNumbersWithNegativeMax() {
        ExerciseOne.printNumbers(-10);
    }

    // Helper method to capture console output
    private String getConsoleOutput() {
        return outContent.toString();
    }
}
