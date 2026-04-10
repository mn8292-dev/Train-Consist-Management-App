import java.util.ArrayList;
import java.util.List;

/**
 * Custom Exception for unsafe cargo combinations.
 */
class CargoSafetyException extends Exception {
    public CargoSafetyException(String message) {
        super(message);
    }
}

/**
 * TrainConsistManagementApp
 * UC15: Safe Cargo Assignment Using try-catch-finally
 */
public class TrainConsistManagementApp {

    public static class GoodsBogie {
        public String type;
        public String cargo;

        public GoodsBogie(String type) {
            this.type = type;
            this.cargo = "Empty";
        }

        /**
         * Dynamically assigns cargo while enforcing safety rules.
         * Rule: Petroleum can ONLY be assigned to Cylindrical bogies.
         */
        public void assignCargo(String newCargo) throws CargoSafetyException {
            if (newCargo.equalsIgnoreCase("Petroleum") && !this.type.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException("Safety Violation: Petroleum cannot be carried in " + this.type + " bogies.");
            }
            this.cargo = newCargo;
        }

        @Override
        public String toString() {
            return type + " bogie currently carrying: " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC15 - Safe Cargo Assignment Handling ");
        System.out.println("==========================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // Attempting multiple assignments to demonstrate try-catch-finally
        String[] cargosToAssign = {"Petroleum", "Coal"};
        GoodsBogie[] bogies = {cylindrical, rectangular};

        for (GoodsBogie bogie : bogies) {
            for (String cargo : cargosToAssign) {
                try {
                    System.out.println("Attempting to assign " + cargo + " to " + bogie.type + "...");
                    bogie.assignCargo(cargo);
                    System.out.println("Success: Assignment completed.");
                } catch (CargoSafetyException e) {
                    System.err.println("Caught Exception: " + e.getMessage());
                } finally {
                    System.out.println("Validation check finished for " + bogie.type + ".\n");
                }
            }
        }

        System.out.println("Final Train Status:");
        System.out.println(cylindrical);
        System.out.println(rectangular);
        System.out.println("\nUC15 structured exception handling completed...");
    }
}