/**
 * TrainConsistManagementApp
 * UC18: Linear Search for Bogie ID (Array-Based Searching)
 */
public class TrainConsistManagementApp {

    /**
     * Searches for a specific bogie ID in an array using Linear Search.
     * Compares the target ID against each element sequentially.
     */
    public static boolean searchBogieID(String[] bogieIDs, String targetID) {
        if (bogieIDs == null || targetID == null) {
            return false;
        }

        for (String id : bogieIDs) {
            // Check if current ID matches the target (case-sensitive)
            if (id.equals(targetID)) {
                return true; // Match found, terminate search immediately
            }
        }
        return false; // Traversed entire array without finding a match
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC18 - Bogie ID Search (Linear Search) ");
        System.out.println("==========================================\n");

        // 1. Array of bogie IDs in the train consist
        String[] trainConsist = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        System.out.println("Scanning train consist for Bogie ID: " + searchKey);

        // 2. Perform Linear Search
        boolean found = searchBogieID(trainConsist, searchKey);

        // 3. Display search result
        if (found) {
            System.out.println("SUCCESS: Bogie " + searchKey + " located in the consist.");
        } else {
            System.out.println("ALERT: Bogie " + searchKey + " not found in this train.");
        }

        System.out.println("\nUC18 search completed...");
    }
}