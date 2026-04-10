import java.util.ArrayList;
import java.util.List;

/**
 * TrainConsistManagementApp
 * UC10: Count Total Seats in Train (reduce)
 */
public class TrainConsistManagementApp {

    // Reusing Bogie model
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
     * Aggregates seating capacity of all bogies into a single total.
     * Uses map() to extract values and reduce() to sum them[cite: 1022, 1023].
     */
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)          // Extract numeric capacity [cite: 1022]
                .reduce(0, Integer::sum);      // Sum capacities with identity 0 [cite: 1023]
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("==========================================\n");

        // 1. User creates a list of bogies [cite: 993, 1010]
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies in the train [cite: 997, 998]
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // 2-4. Aggregation logic [cite: 981, 982]
        int totalSeats = calculateTotalSeats(bogies);

        // 5. Display total seat count [cite: 983, 1011]
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nUC10 aggregation completed...");
    }
}