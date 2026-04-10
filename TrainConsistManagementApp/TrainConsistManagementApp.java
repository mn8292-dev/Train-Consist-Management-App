import java.util.Arrays;

/**
 * TrainConsistManagementApp
 * UC19: Binary Search for Bogie ID (Optimized Searching)
 */
public class TrainConsistManagementApp {

    /**
     * Performs Binary Search on an array of bogie IDs.
     * Note: The array MUST be sorted for Binary Search to work.
     */
    public static boolean binarySearchBogieID(String[] bogieIDs, String targetID) {
        if (bogieIDs == null || targetID == null || bogieIDs.length == 0) {
            return false;
        }

        // Binary Search requires sorted data
        Arrays.sort(bogieIDs);

        int low = 0;
        int high = bogieIDs.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = targetID.compareTo(bogieIDs[mid]);

            if (comparison == 0) {
                return true; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC19 - Optimized Search (Binary Search) ");
        System.out.println("==========================================\n");

        // Unsorted array of IDs
        String[] trainConsist = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchKey = "BG205";

        System.out.println("Searching for Bogie ID: " + searchKey);

        // Apply Binary Search
        boolean found = binarySearchBogieID(trainConsist, searchKey);

        if (found) {
            System.out.println("SUCCESS: Bogie " + searchKey + " located quickly via Binary Search.");
        } else {
            System.out.println("ALERT: Bogie " + searchKey + " not found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}