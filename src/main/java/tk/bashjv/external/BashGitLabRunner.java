/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * The type Bash git lab runner.
 * Class that manage the gitlab runner
 * implementations
 */
public class BashGitLabRunner {
    /**
     * Gets runner status.
     *
     * @param consoleOutput the console output for the helm namespaces
     * @return the runner status
     */
    public static Ansi getRunnerStatus(String consoleOutput) {
        if (consoleOutput.contains("gitlab-runner") && consoleOutput.contains("deployed")) {
            return ansi().render("Gitlab runner -- @|GREEN RUNNING |@");
        } else {
            return ansi().render("Gitlab runner -- @|RED NOT RUNNING |@");
        }
    }
}
