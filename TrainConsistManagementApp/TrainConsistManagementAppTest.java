import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        // Verifies that a correctly formatted Train ID is accepted
        assertTrue(TrainConsistManagementApp.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Verifies that incorrectly formatted Train IDs are rejected
        assertFalse(TrainConsistManagementApp.validateTrainID("TRAIN12"));
        assertFalse(TrainConsistManagementApp.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Verifies that Train ID contains exactly four digits
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-123"));
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        // Verifies that a Cargo Code following the correct format is accepted
        assertTrue(TrainConsistManagementApp.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        // Verifies that incorrectly formatted Cargo Codes are rejected
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Verifies that Cargo Code accepts only uppercase characters
        assertFalse(TrainConsistManagementApp.validateCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.validateCargoCode("pet-AB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        // Verifies behavior when empty strings are provided
        assertFalse(TrainConsistManagementApp.validateTrainID(""));
        assertFalse(TrainConsistManagementApp.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // Verifies that the entire input must match the pattern
        assertFalse(TrainConsistManagementApp.validateTrainID("TRN-1234 extra"));
    }
}