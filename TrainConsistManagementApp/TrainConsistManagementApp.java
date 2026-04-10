import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TrainConsistManagementApp
 * UC8: Filter Passenger Bogies Using Streams
 */
public class TrainConsistManagementApp {

    // Reusing Bogie model from UC7
    // Marked public so the test class can access it
    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Standard filtering method using Stream API.
     * Selects bogies where capacity is strictly greater than the threshold.
     */
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()                         // Convert list to stream [cite: 65, 72]
                .filter(b -> b.capacity > threshold)   // Apply filter condition [cite: 66, 73]
                .collect(Collectors.toList());        // Collect results into a new list [cite: 68, 74]
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("==============================================\n");

        // 1. User creates a list of bogies [cite: 52]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // Apply filtering logic with a threshold of 60 [cite: 73]
        List<Bogie> filteredBogies = filterBogies(bogies, 60);

        // 5. Display qualifying bogies [cite: 56, 75]
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");
    }
}