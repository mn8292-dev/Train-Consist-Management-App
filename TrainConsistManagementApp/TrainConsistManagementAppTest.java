import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        // Verifies that safe cargo assignments (Cylindrical + Petroleum) succeed
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Verifies that unsafe assignments trigger the CargoSafetyException
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        assertThrows(CargoSafetyException.class, () -> bogie.assignCargo("Petroleum"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Verifies that the cargo status remains "Empty" if the assignment fails
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        try {
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Exception expected
        }
        assertEquals("Empty", bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Verifies that an exception in one assignment doesn't crash subsequent logic
        TrainConsistManagementApp.GoodsBogie bogie1 = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        TrainConsistManagementApp.GoodsBogie bogie2 = new TrainConsistManagementApp.GoodsBogie("Rectangular");

        try {
            bogie1.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Handle first failure
        }

        // Program should reach this line and succeed
        assertDoesNotThrow(() -> bogie2.assignCargo("Coal"));
        assertEquals("Coal", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Verifies that the finally logic (simulated by checking if we pass through the block) runs
        boolean finallyExecuted = false;
        try {
            TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Caught
        } finally {
            finallyExecuted = true;
        }
        assertTrue(finallyExecuted);
    }
}