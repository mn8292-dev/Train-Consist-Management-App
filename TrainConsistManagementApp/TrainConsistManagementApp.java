import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * TrainConsistManagementApp
 * UC11: Validate Train ID & Cargo Codes (Regex)
 */
public class TrainConsistManagementApp {

    // Regex Patterns
    // Train ID: Starts with "TRN-" followed by exactly 4 digits [cite: 52]
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";

    // Cargo Code: 3 uppercase letters, a hyphen, and 2 uppercase letters (e.g., PET-AB) [cite: 53]
    private static final String CARGO_CODE_REGEX = "^[A-Z]{3}-[A-Z]{2}$";

    /**
     * Validates if the Train ID follows the format TRN-XXXX (where X is a digit).
     */
    public static boolean validateTrainID(String trainID) {
        if (trainID == null) return false;
        return Pattern.matches(TRAIN_ID_REGEX, trainID);
    }

    /**
     * Validates if the Cargo Code follows the format AAA-BB (Uppercase letters).
     */
    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("==========================================\n");

        // Sample Inputs for demonstration
        String[] trainIDs = {"TRN-1234", "TRN-12", "1234-TRN"};
        String[] cargoCodes = {"PET-AB", "pet-ab", "PET123"};

        System.out.println("Train ID Validation:");
        for (String id : trainIDs) {
            System.out.println(id + " -> " + (validateTrainID(id) ? "Valid" : "Invalid"));
        }

        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes) {
            System.out.println(code + " -> " + (validateCargoCode(code) ? "Valid" : "Invalid"));
        }

        System.out.println("\nUC11 validation completed...");
    }
}