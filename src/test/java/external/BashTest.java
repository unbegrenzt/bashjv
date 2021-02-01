/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package external;

import org.junit.jupiter.api.Test;
import tk.bashjv.external.Bash;
import tk.bashjv.utils.ExtCommands;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BashTest {

    @Test
    void execute_HasCoreCommand_PrintsCore() throws IOException {
        String actual = Bash.execute(ExtCommands.VALID_PSCORE);
        assertTrue(actual.contains("Core"));
    }
}
