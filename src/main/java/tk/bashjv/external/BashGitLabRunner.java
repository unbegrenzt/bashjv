/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import tk.bashjv.utils.ExtCommands;

import java.io.IOException;

public class BashGitLabRunner {

    public static String getRunnerStatus() throws IOException {
        return Bash.execute(ExtCommands.VALID_PSCORE);
    }
}
