import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies that searching an empty array triggers an IllegalStateException
        String[] bogieIDs = {};
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG101");
        });
        assertEquals("Search failed: No bogies found in the train consist.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies that the search executes without exception if data is present
        String[] bogieIDs = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies that a bogie is correctly found after passing state validation
        String[] bogieIDs = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies that false is returned (not an exception) if the ID isn't in a non-empty list
        String[] bogieIDs = {"BG101", "BG205", "BG309"};
        assertFalse(TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        // Verifies correct behavior for a train with exactly one bogie
        String[] bogieIDs = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchWithValidation(bogieIDs, "BG101"));
    }

    @Test
    void testSearch_NullInputThrowsException() {
        // Verifies that null input is also caught by the fail-fast check
        assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchWithValidation(null, "BG101");
        });
    }
}