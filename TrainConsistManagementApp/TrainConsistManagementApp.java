import java.util.Arrays;

/**
 * TrainConsistManagementApp
 * UC17: Sort Bogie Names Using Arrays.sort()
 */
public class TrainConsistManagementApp {

    /**
     * Sorts an array of bogie names alphabetically.
     * Uses Java's built-in optimized Dual-Pivot Quicksort/TimSort.
     */
    public static void sortBogieNames(String[] names) {
        if (names != null) {
            Arrays.sort(names);
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC17 - Alphabetical Sorting (Arrays.sort) ");
        System.out.println("==========================================\n");

        // 1. Array of unsorted bogie names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Names: " + Arrays.toString(bogieNames));

        // 2. Apply built-in sorting
        sortBogieNames(bogieNames);

        // 3. Display sorted results
        System.out.println("Sorted Names:   " + Arrays.toString(bogieNames));

        System.out.println("\nUC17 optimized sorting completed...");
    }
}