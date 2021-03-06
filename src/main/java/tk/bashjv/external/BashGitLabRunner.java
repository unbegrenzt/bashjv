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
            return ansi().render("@|CYAN * |@Gitlab runner -- @|GREEN Running |@");
        } else {
            return ansi().render(
                    "@|CYAN * |@Gitlab runner -- @|RED Disabled |@" + System.lineSeparator() +
                    "@|CYAN  \\_ |@" +
                    "See more -- " +
                    "@|BLUE https://docs.gitlab.com/runner/install/kubernetes.html use *gitlab-runner* namespace |@"
            );
        }
    }
}
