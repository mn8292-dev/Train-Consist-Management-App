import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Verifies that bogies with the same name appear under the same Map key [cite: 618, 619]
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("AC Chair", 56)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        // Verifies that multiple bogies with the same type are stored in the same list [cite: 621, 622]
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("Sleeper", 70)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        // Verifies different categories are separated into different groups [cite: 624, 625]
        List<TrainConsistManagementApp.Bogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.Bogie("Sleeper", 72),
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(bogies);

        assertNotEquals(result.get("Sleeper"), result.get("First Class"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Verifies grouping an empty list returns an empty Map [cite: 626, 627]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        // Verifies the Map contains expected keys like Sleeper, AC Chair [cite: 632, 633]
        List<TrainConsistManagementApp.Bogie> bogies = Collections.singletonList(
                new TrainConsistManagementApp.Bogie("First Class", 24)
        );

        Map<String, List<TrainConsistManagementApp.Bogie>> result = TrainConsistManagementApp.groupBogiesByType(bogies);

        assertTrue(result.containsKey("First Class"));
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Verifies the original bogie list remains unchanged after the operation [cite: 638, 639]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.groupBogiesByType(bogies);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}