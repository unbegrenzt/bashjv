/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.fusesource.jansi.Ansi;
import tk.bashjv.external.outputs.DoctorOutputs;
import picocli.CommandLine.Model.CommandSpec;

import java.io.IOException;

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

    /**
     * Gets wsl status.
     *
     * @param consoleOutput the console output
     * @return the wsl status formatted output
     */
    public static Ansi getWslStatus(String consoleOutput) {
        if (consoleOutput.contains("State") && consoleOutput.contains("Enabled")) {
            return ansi().render(
                    "@|CYAN * |@WSL -- @|GREEN Enabled |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "See more -- " +
                            "@|BLUE docs.microsoft.com/en-us/windows/wsl/install-win10 |@" +
                            "website" + System.lineSeparator() +
                            "@|CYAN  !_ |@" +
                            "Use -- " +
                            "@|BLUE wsl version 2 |@"
            );
        } else {
            return ansi().render(
                    "@|CYAN * |@WSL -- @|RED Disabled |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "See more -- " +
                            "@|BLUE docs.microsoft.com/en-us/windows/wsl/install-win10 |@" +
                            "website"
            );
        }
    }

    /**
     * Gets doctor.
     *
     * @param spec the spec
     * @throws IOException the io exception
     */
    public static void getDoctor(CommandSpec spec) throws IOException {
        String consoleOutput = DoctorOutputs.hyperStatus();
        Ansi output = BashDoctor.getHyperStatus(consoleOutput);
        spec.commandLine().getOut().println(output);

        consoleOutput = DoctorOutputs.wslStatus();
        output = BashDoctor.getWslStatus(consoleOutput);
        spec.commandLine().getOut().println(output);
    }
}
