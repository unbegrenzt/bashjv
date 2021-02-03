/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import tk.bashjv.utils.ExtCommands;

import java.io.IOException;

/**
 * The type Bash git lab runner.
 * Class that manage the gitlab runner
 * implementations
 */
public class BashGitLabRunner {

    /**
     * Gets runner status.
     *
     * @return the runner status
     * @throws IOException the io exception
     */
    public static String getRunnerStatus() throws IOException {
        return Bash.execute(ExtCommands.VALID_PSCORE);
    }
}
