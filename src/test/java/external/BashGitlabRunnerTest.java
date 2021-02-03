/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package external;

import org.junit.jupiter.api.Test;
import tk.bashjv.external.BashGitLabRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BashGitlabRunnerTest {

    @Test
    void getRunnerStatus_NoArguments_NoThrow() throws IOException {
        String actual = BashGitLabRunner.getRunnerStatus();
        assertDoesNotThrow(() -> actual);
    }
}
