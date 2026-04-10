import java.util.*;
import java.util.stream.Collectors;

/**
 * TrainConsistManagementApp
 * UC9: Group Bogies by Type (Collectors.groupingBy)
 */
public class TrainConsistManagementApp {

    // Reusing Bogie model from UC7/UC8 [cite: 520]
    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Capacity -> " + capacity;
        }
    }

    /**
     * Groups bogies using Collectors.groupingBy[cite: 508, 549].
     * Categorizes bogies by their name field.
     */
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()                         // 2. Stream the list [cite: 511, 557]
                .collect(Collectors.groupingBy(b -> b.name)); // 3. groupingBy collector applied [cite: 512, 558]
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("==========================================\n");

        // 1. User creates a list of bogies [cite: 510, 556]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // 4. Bogies are grouped into a Map [cite: 559]
        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        // 5. Grouped result is displayed [cite: 514, 560]
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }

        System.out.println("\nUC9 grouping completed...");
    }
}