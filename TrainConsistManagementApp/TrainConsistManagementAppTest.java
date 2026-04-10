import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Verifies bogies with capacity > 70 are returned [cite: 112, 113]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 75));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Verifies bogies with capacity equal to 70 are excluded [cite: 115, 116]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 70));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        // Verifies bogies with capacity less than 70 are excluded [cite: 118, 119]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        // Verifies that all matching bogies are returned [cite: 121, 122]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // Verifies result is empty if no bogies satisfy the condition [cite: 124, 125]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertEquals(0, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Verifies that filtering an empty list does not cause errors [cite: 130, 131]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        // Verifies the original collection remains unchanged [cite: 133, 134]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.filterBogies(bogies, 60);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}