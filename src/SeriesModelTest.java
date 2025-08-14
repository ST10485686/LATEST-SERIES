import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeriesModelTest {

    @Test
    void testSeriesModelGettersAndSetters() {
        SeriesModel series = new SeriesModel();

        // Test setters and getters
        series.setSeriesId("101");
        series.setSeriesName("Test Series");
        series.setSeriesAge("12");
        series.setSeriesNumberOfEpisodes("10");

        assertEquals("101", series.getSeriesId());
        assertEquals("Test Series", series.getSeriesName());
        assertEquals("12", series.getSeriesAge());
        assertEquals("10", series.getSeriesNumberOfEpisodes());
    }

    @Test
    void testSeriesModelEquality() {
        SeriesModel series1 = new SeriesModel();
        series1.setSeriesId("101");

        SeriesModel series2 = new SeriesModel();
        series2.setSeriesId("101");

        SeriesModel series3 = new SeriesModel();
        series3.setSeriesId("102");

        assertEquals(series1.getSeriesId(), series2.getSeriesId());
        assertNotEquals(series1.getSeriesId(), series3.getSeriesId());
    }
}