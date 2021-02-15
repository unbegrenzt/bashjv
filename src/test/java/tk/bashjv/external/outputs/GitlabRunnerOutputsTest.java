/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external.outputs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GitlabRunnerOutputsTest {

    @Test
    void gitlabRunnerStatus_NoArguments_NotThrows() {
        assertDoesNotThrow(GitlabRunnerOutputs::gitlabRunnerStatus);
    }
}
