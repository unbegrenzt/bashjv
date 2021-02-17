/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external.outputs;

import org.junit.jupiter.api.Test;

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

    @Test
    void dockerKubStatus_NoArguments_NotThrows() {
        assertDoesNotThrow(DoctorOutputs::dockerKubStatus);
    }

    @Test
    void helmStatus_NoArguments_NotThrows() {
        assertDoesNotThrow(DoctorOutputs::helmStatus);
    }
}