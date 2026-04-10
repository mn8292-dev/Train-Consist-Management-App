import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        // Verifies that an existing bogie ID is correctly identified
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies that a non-existent bogie ID returns false
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies that the search correctly identifies a match at index 0
        String[] bogieIDs = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies that the search correctly identifies a match at the final index
        String[] bogieIDs = {"BG101", "BG205", "BG550"};
        assertTrue(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies that search works when only one bogie exists
        String[] bogieIDs = {"BG101"};
        assertTrue(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG101"));
        assertFalse(TrainConsistManagementApp.searchBogieID(bogieIDs, "BG205"));
    }

    @Test
    void testSearch_NullHandling() {
        // Verifies that null inputs do not cause crashes
        assertFalse(TrainConsistManagementApp.searchBogieID(null, "BG101"));
        String[] bogieIDs = {"BG101"};
        assertFalse(TrainConsistManagementApp.searchBogieID(bogieIDs, null));
    }
}