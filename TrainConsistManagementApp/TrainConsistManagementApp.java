import java.util.ArrayList;
import java.util.List;

/**
 * Custom Exception for handling invalid bogie capacity scenarios.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * TrainConsistManagementApp
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 */
public class TrainConsistManagementApp {

    public static class Bogie {
        public String name;
        public int capacity;

        /**
         * Constructor enforcing the rule: Capacity must be greater than zero.
         * Throws InvalidCapacityException if the rule is violated.
         */
        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC14 - Custom Exception Handling ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();

        try {
            System.out.println("Adding valid bogie...");
            bogies.add(new Bogie("Sleeper", 72));

            System.out.println("Adding invalid bogie (Zero Capacity)...");
            // This line will trigger the exception
            bogies.add(new Bogie("General", 0));

        } catch (InvalidCapacityException e) {
            System.err.println("Error creating bogie: " + e.getMessage());
        }

        System.out.println("\nFinal Bogie List Count: " + bogies.size());
        System.out.println("\nUC14 exception handling completed...");
    }
}