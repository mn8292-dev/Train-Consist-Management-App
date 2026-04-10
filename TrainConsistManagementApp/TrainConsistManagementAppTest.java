import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        // Verifies that an existing ID is found in a list
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        // Verifies return false for non-existent IDs
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        // Verifies it finds the first element (alphabetically)
        String[] bogieIDs = {"BG550", "BG101", "BG205"};
        assertTrue(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        // Verifies it finds the last element (alphabetically)
        String[] bogieIDs = {"BG101", "BG205", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        // Verifies safe handling of empty lists
        String[] bogieIDs = {};
        assertFalse(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Verifies that the internal sort allows searching through unsorted input
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(TrainConsistManagementApp.binarySearchBogieID(bogieIDs, "BG205"));
    }
}