import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        // Verifies typical alphabetical sorting for bogie names
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(names);
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_UnsortedInput() {
        // Verifies that a randomly ordered array is correctly rearranged
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(names);
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that a sorted array remains in the correct order
        String[] names = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        TrainConsistManagementApp.sortBogieNames(names);
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        // Verifies that duplicates are grouped together correctly
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(names);
        assertArrayEquals(expected, names);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that a single element array is handled without error
        String[] names = {"Sleeper"};
        String[] expected = {"Sleeper"};

        TrainConsistManagementApp.sortBogieNames(names);
        assertArrayEquals(expected, names);
    }
}