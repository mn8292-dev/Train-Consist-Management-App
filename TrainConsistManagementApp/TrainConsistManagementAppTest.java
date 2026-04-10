import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Verifies that a bogie with capacity greater than zero is created without error
        assertDoesNotThrow(() -> {
            new TrainConsistManagementApp.Bogie("Sleeper", 72);
        });
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies that a negative capacity triggers the custom exception
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new TrainConsistManagementApp.Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies that zero capacity is treated as invalid input
        assertThrows(InvalidCapacityException.class, () -> {
            new TrainConsistManagementApp.Bogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Verifies that the correct error message is returned
        try {
            new TrainConsistManagementApp.Bogie("AC Chair", -5);
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        // Verifies that valid bogie objects store the correct values
        TrainConsistManagementApp.Bogie bogie = new TrainConsistManagementApp.Bogie("First Class", 24);
        assertEquals("First Class", bogie.name);
        assertEquals(24, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        // Verifies that multiple valid bogies can be created in succession
        assertDoesNotThrow(() -> {
            new TrainConsistManagementApp.Bogie("Sleeper", 72);
            new TrainConsistManagementApp.Bogie("AC Chair", 56);
        });
    }
}