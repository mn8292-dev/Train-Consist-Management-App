import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        // Verifies train is marked safe when all cylindrical bogies carry Petroleum [cite: 104, 106]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.Bogie("Open", "Coal"));

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        // Verifies that cylindrical bogies carrying non-petroleum cargo fail validation [cite: 107, 108]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        // Verifies that non-cylindrical bogies can carry any cargo safely [cite: 109, 111]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Open", "Chemicals"));
        bogies.add(new TrainConsistManagementApp.Bogie("Box", "Electronics"));

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        // Verifies that a single violation makes the entire train unsafe
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        bogies.add(new TrainConsistManagementApp.Bogie("Cylindrical", "Petroleum"));
        bogies.add(new TrainConsistManagementApp.Bogie("Cylindrical", "Water")); // Violation [cite: 112]

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        // Verifies behavior when no goods bogies exist (should be safe) [cite: 115, 117]
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }
}