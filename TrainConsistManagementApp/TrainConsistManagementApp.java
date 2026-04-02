import java.util.HashSet;
import java.util.Set;

/**
 * MAIN CLASS - UseCase3TrainConsistMgmt
 * Use Case 3: Track Unique Bogie IDs
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // 1. Display Header
        System.out.println("...............................");
        System.out.println("   UC3: Track Unique Bogie IDs ");
        System.out.println("...............................\n");

        // 2. Create a Set to store unique bogie IDs
        // HashSet stores only unique values and uses hashing for fast access
        Set<String> bogies = new HashSet<>();

        // 3. ADD IDs (including intentional duplicates)
        // add() inserts bogie IDs into the set
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // 4. Duplicate entries will be ignored internally by HashSet
        // This enforces business rules automatically without manual checks
        bogies.add("BG101"); // Duplicate entry
        bogies.add("BG102"); // Duplicate entry

        // 5. Display the unique bogie identifiers
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        // 6. Observation Note
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("UC3 uniqueness validation completed...");
    }
}