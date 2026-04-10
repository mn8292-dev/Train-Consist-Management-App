import java.util.Arrays;

/**
 * TrainConsistManagementApp
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort)
 */
public class TrainConsistManagementApp {

    /**
     * Sorts an array of bogie capacities using the Bubble Sort algorithm.
     * This is a manual comparison-based sorting approach.
     */
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        // Outer loop to traverse the entire array
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for pairwise comparison
            for (int j = 0; j < n - i - 1; j++) {
                // If the current element is greater than the next, swap them
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC16 - Manual Sorting (Bubble Sort) ");
        System.out.println("==========================================\n");

        // 1. Array of unsorted passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities: " + Arrays.toString(capacities));

        // 2. Apply Bubble Sort algorithm
        bubbleSort(capacities);

        // 3. Display sorted results
        System.out.println("Sorted Capacities:   " + Arrays.toString(capacities));

        System.out.println("\nUC16 manual sorting completed...");
    }
}