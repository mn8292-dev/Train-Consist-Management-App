import java.util.ArrayList;
import java.util.List;

/**
 * TrainConsistManagementApp
 * UC12: Safety Compliance Check for Goods Bogies
 */
public class TrainConsistManagementApp {

    // Bogie model including type and cargo for safety validation
    public static class Bogie {
        public String name;    // e.g., "Cylindrical", "Open", "Box"
        public String cargo;   // e.g., "Petroleum", "Coal" [cite: 13]

        public Bogie(String name, String cargo) {
            this.name = name;
            this.cargo = cargo;
        }
    }

    /**
     * Checks if the train is safe based on cargo rules.
     * Rule: Cylindrical bogies MUST carry Petroleum. [cite: 12, 62]
     * Uses allMatch() to ensure every bogie satisfies the safety condition. [cite: 62]
     */
    public static boolean isTrainSafe(List<Bogie> goodsBogies) {
        // If no goods bogies exist, the train is safe by default [cite: 14]
        return goodsBogies.stream().allMatch(b -> {
            if (b.name.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum"); // Safety constraint [cite: 12, 62]
            }
            return true; // Non-cylindrical bogies are always safe regardless of cargo [cite: 13]
        });
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC12 - Safety Compliance Check ");
        System.out.println("==========================================\n");

        // 1. User creates a list of goods bogies [cite: 42, 53]
        List<Bogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new Bogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new Bogie("Open", "Coal"));
        goodsBogies.add(new Bogie("Box", "Grain"));
        goodsBogies.add(new Bogie("Cylindrical", "Petroleum"));

        // 2. Perform safety validation [cite: 54]
        boolean safe = isTrainSafe(goodsBogies);

        // 3. Display safety status [cite: 55]
        System.out.println("Safety Check Results:");
        for (Bogie b : goodsBogies) {
            System.out.println(b.name + " carrying " + b.cargo);
        }

        System.out.println("\nIs Train Formation Safe? " + (safe ? "YES" : "NO"));
        System.out.println("\nUC12 safety check completed..."); [cite: 14]
    }
}