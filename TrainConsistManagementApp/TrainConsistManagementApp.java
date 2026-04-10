import java.util.Arrays;

/**
 * TrainConsistManagementApp
 * UC20: Exception Handling During Search Operations
 */
public class TrainConsistManagementApp {

    /**
     * Searches for a bogie ID but validates that the train is not empty first.
     * Throws IllegalStateException to prevent operations on empty data.
     */
    public static boolean searchWithValidation(String[] bogieIDs, String targetID) {
        // Fail-Fast: Check if the data exists before processing
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("Search failed: No bogies found in the train consist.");
        }

        // Standard Linear Search logic (as introduced in UC18)
        for (String id : bogieIDs) {
            if (id != null && id.equals(targetID)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC20 - Search Validation & Exceptions ");
        System.out.println("==========================================\n");

        // Scenario 1: Searching an empty train (Should trigger exception)
        String[] emptyTrain = {};
        try {
            System.out.println("Attempting search on empty train...");
            searchWithValidation(emptyTrain, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }

        // Scenario 2: Searching a valid train
        String[] validTrain = {"BG101", "BG205", "BG309"};
        try {
            System.out.println("\nAttempting search on valid train...");
            boolean found = searchWithValidation(validTrain, "BG205");
            System.out.println("Search Result: " + (found ? "Found" : "Not Found"));
        } catch (IllegalStateException e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }

        System.out.println("\nUC20 exception handling completed...");
    }
}