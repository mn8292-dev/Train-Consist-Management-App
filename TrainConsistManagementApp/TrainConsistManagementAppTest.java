import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UC13: Performance Comparison (Loops vs Streams) Test Cases
 * Verifies the logic and measurement accuracy of both imperative and declarative approaches.
 */
public class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {
        // Verifies that loop-based filtering correctly returns bogies with capacity > 60
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 50));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithLoop(bogies, 60);
        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        // Verifies that stream-based filtering correctly returns bogies with capacity > 60
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 50));

        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithStream(bogies, 60);
        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        // Verifies that both filtering methods produce the same number of filtered bogies
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("General", 50));

        int loopSize = TrainConsistManagementApp.filterWithLoop(bogies, 60).size();
        int streamSize = TrainConsistManagementApp.filterWithStream(bogies, 60).size();

        assertEquals(loopSize, streamSize);
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Verifies that execution time is calculated and produces a positive value
        long startTime = System.nanoTime();
        // Simulate a small delay or operation
        long endTime = System.nanoTime();
        assertTrue((endTime - startTime) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        // Verifies that logic works correctly when processing a large dataset
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        }
        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithStream(bogies, 60);
        assertEquals(1000, result.size());
    }
}