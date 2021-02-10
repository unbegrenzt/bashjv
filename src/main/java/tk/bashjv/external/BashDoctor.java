/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.fusesource.jansi.Ansi;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * The type Bash doctor.
 * backlog for the doctor sub-command
 */
public class BashDoctor {


    /**
     * Gets hyper status.
     *
     * @param consoleOutput the console output from the Factory
     * @return if hyper -v is enabled or disabled
     */
    public static Ansi getHyperStatus(String consoleOutput) {
        if (consoleOutput.contains("State") && consoleOutput.contains("Enabled")) {
            return ansi().render(
                    "@|CYAN * |@ Hyper-v -- @|GREEN Enabled |@"
            );
        } else {
            return ansi().render(
                    "@|CYAN * |@Hyper-v -- @|RED Disabled |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "Use pwsh -- " +
                            "@|BLUE Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All |@" +
                            "Command"
            );
        }
    }

    public static Ansi getWslStatus(String consoleOutput) {
        if (consoleOutput.contains("State") && consoleOutput.contains("Enabled")) {
            return ansi().render(
                    "@|CYAN * |@ Hyper-v -- @|GREEN Enabled |@"
            );
        } else {
            return ansi().render(
                    "@|CYAN * |@Hyper-v -- @|RED Disabled |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "Use pwsh -- " +
                            "@|BLUE Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All |@" +
                            "Command"
            );
        }
    }
}
