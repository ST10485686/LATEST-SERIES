import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SeriesManagementAppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static SeriesManagementApp app;
    private static ArrayList<SeriesModel> originalSeriesList;


    @Test
    void testDisplayWelcomeMessageContinue() {
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        SeriesManagementApp.displayWelcomeMessage();
        assertTrue(outContent.toString().contains("LATEST SERIES - 2025"));
    }

    @Test
    void testDisplayWelcomeMessageExit() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertDoesNotThrow(() -> {
            SeriesManagementApp.displayWelcomeMessage();
        });
    }

    @Test
    void testCaptureNewSeries() {
        String input = "104\nTest Series\n12\n10\n";
        provideInput(input);

        SeriesManagementApp.captureNewSeries();

        assertEquals(1, SeriesManagementApp.getSeriesList().size());
        assertEquals("104", SeriesManagementApp.getSeriesList().get(0).getSeriesId());
    }

    @Test
    void testSearchForSeriesFound() {
        // Add test data
        SeriesModel testSeries = new SeriesModel();
        testSeries.setSeriesId("105");
        testSeries.setSeriesName("Test Search");
        SeriesManagementApp.getSeriesList().add(testSeries);

        String input = "105\n";
        provideInput(input);

        SeriesManagementApp.searchForSeries();
        assertTrue(outContent.toString().contains("Test Search"));
    }

    @Test
    void testSearchForSeriesNotFound() {
        String input = "999\n";
        provideInput(input);

        SeriesManagementApp.searchForSeries();
        assertTrue(outContent.toString().contains("No series found"));
    }

    @Test
    void testUpdateAgeRestriction() {
        // Add test data
        SeriesModel testSeries = new SeriesModel();
        testSeries.setSeriesId("106");
        testSeries.setSeriesAge("10");
        SeriesManagementApp.getSeriesList().add(testSeries);

        String input = "106\n18\n";
        provideInput(input);

        SeriesManagementApp.updateAgeRestriction();
        assertEquals("18", SeriesManagementApp.getSeriesList().get(0).getSeriesAge());
    }

    @Test
    void testDeleteSeries() {
        // Add test data
        SeriesModel testSeries = new SeriesModel();
        testSeries.setSeriesId("107");
        SeriesManagementApp.getSeriesList().add(testSeries);

        String input = "107\n";
        provideInput(input);

        SeriesManagementApp.deleteSeries();
        assertEquals(0, SeriesManagementApp.getSeriesList().size());
    }

    @Test
    void testPrintSeriesReport() {
        // Add test data
        SeriesModel testSeries = new SeriesModel();
        testSeries.setSeriesId("108");
        testSeries.setSeriesName("Report Test");
        SeriesManagementApp.getSeriesList().add(testSeries);

        SeriesManagementApp.printSeriesReport();
        String output = outContent.toString();
        assertTrue(output.contains("Series Report 2025"));
        assertTrue(output.contains("Report Test"));
    }

    private void provideInput(String data) {
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }
}