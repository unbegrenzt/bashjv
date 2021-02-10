/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package external.outputs;

import org.junit.jupiter.api.Test;
import tk.bashjv.external.outputs.DoctorOutputs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DoctorOutputsTest {

    @Test
    void hyperStatus_NoArguments_NotThrows() {
        assertDoesNotThrow(DoctorOutputs::hyperStatus);
    }

    @Test
    void wslStatus_NoArguments_NotThrows() {
        assertDoesNotThrow(DoctorOutputs::wslStatus);
    }
}