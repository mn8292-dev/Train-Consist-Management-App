import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicSorting() {
        // Verifies that Bubble Sort correctly sorts a typical unsorted array
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies that duplicate capacities are handled correctly
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element array does not modify it
        int[] capacities = {50};
        int[] expected = {50};

        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies that arrays containing identical values remain unchanged
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};

        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(expected, capacities);
    }
}