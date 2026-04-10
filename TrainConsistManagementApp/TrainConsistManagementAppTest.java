import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        // Verifies the computed total equals the sum of all bogie capacities [cite: 1057]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));
        bogies.add(new TrainConsistManagementApp.Bogie("AC Chair", 56));

        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(128, total); // 72 + 56 = 128
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Verifies behavior when only one bogie exists [cite: 1061, 1062]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("General", 90));

        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(90, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Verifies that an empty list returns the identity value (0) [cite: 1064, 1065]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // Verifies map() correctly extracts capacity values [cite: 1067, 1068]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("First Class", 24));

        int total = TrainConsistManagementApp.calculateTotalSeats(bogies);
        assertEquals(24, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Verifies original list integrity after stream processing [cite: 1072, 1073]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Sleeper", 72));

        TrainConsistManagementApp.calculateTotalSeats(bogies);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}