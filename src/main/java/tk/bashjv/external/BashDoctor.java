/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
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
                    "@|CYAN * |@Hyper-v -- @|GREEN Enabled |@"
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
     * Gets docker and kubernetes status.
     *
     * @param consoleOutput the console output
     * @return the docker kubernetes status formatted output
     */
    public static Ansi getDockerKubStatus(String consoleOutput) {
        if (consoleOutput.contains("Client: Docker Engine") &&
                consoleOutput.contains("Server: Docker Engine") &&
                !consoleOutput.contains("Kubernetes:")) {
            return ansi().render(
                    "@|CYAN * |@Docker -- @|GREEN Running |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "Kubernetes -- " +
                            "@|RED Not Running |@" + System.lineSeparator() +
                            "@|CYAN  !_ |@" +
                            "Recommended -- " +
                            "@|BLUE Start Kubernetes |@"
            );
        } else if (consoleOutput.contains("Client: Docker Engine") &&
                consoleOutput.contains("Server: Docker Engine") &&
                consoleOutput.contains("Kubernetes:")) {
            return ansi().render(
                    "@|CYAN * |@Docker -- @|GREEN Running |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "Kubernetes -- " +
                            "@|GREEN Running |@"
            );
        } else if (consoleOutput.contains("Client: Docker Engine") &&
                !consoleOutput.contains("Server: Docker Engine")) {
            return ansi().render(
                    "@|CYAN * |@Docker -- @|RED Not Running |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "Kubernetes -- " +
                            "@|RED Not Running |@" + System.lineSeparator() +
                            "@|CYAN  !_ |@" +
                            "Recommended -- " +
                            "@|BLUE Start docker server |@"
            );
        }

        return ansi().render(
                "@|CYAN * |@Docker -- @|RED Disabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE https://www.docker.com/get-started |@"
        );
    }

    /**
     * Gets helm status.
     *
     * @param consoleOutput the console output
     * @return the helm status formatted output
     */
    public static Ansi getHelmStatus(String consoleOutput) {
        if (consoleOutput.contains("Version:")) {
            return ansi().render(
                    "@|CYAN * |@Helm -- @|GREEN Installed |@"
            );
        } else {
            return ansi().render(
                    "@|CYAN * |@Helm -- @|RED Not Installed |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "See more -- " +
                            "@|BLUE https://helm.sh/docs/intro/quickstart/ |@"
            );
        }
    }

    /**
     * Gets pwsh status.
     *
     * @param consoleOutput the console output
     * @return the pwsh status formatted output
     */
    public static Ansi getPwshStatus(String consoleOutput) {
        if (consoleOutput.contains("PowerShell")) {
            return ansi().render(
                    "@|CYAN * |@PowerShell Core -- @|GREEN Installed |@"
            );
        } else {
            return ansi().render(
                    "@|CYAN * |@PowerShell Core -- @|RED Not Installed |@" + System.lineSeparator() +
                            "@|CYAN  \\_ |@" +
                            "See more -- " +
                            "@|BLUE https://github.com/PowerShell/PowerShell |@"
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
        AnsiConsole.systemInstall();
        //powershell core
        String consoleOutput = DoctorOutputs.pwshStatus();
        Ansi output = BashDoctor.getPwshStatus(consoleOutput);
        spec.commandLine().getOut().println(output);

        //Hyper-v
        consoleOutput = DoctorOutputs.hyperStatus();
        output = BashDoctor.getHyperStatus(consoleOutput);
        spec.commandLine().getOut().println(output);

        //WSL
        consoleOutput = DoctorOutputs.wslStatus();
        output = BashDoctor.getWslStatus(consoleOutput);
        spec.commandLine().getOut().println(output);

        //Docker - Kubernetes
        consoleOutput = DoctorOutputs.dockerKubStatus();
        output = BashDoctor.getDockerKubStatus(consoleOutput);
        spec.commandLine().getOut().println(output);

        //Helm
        consoleOutput = DoctorOutputs.helmStatus();
        output = BashDoctor.getHelmStatus(consoleOutput);
        spec.commandLine().getOut().println(output);
        AnsiConsole.systemUninstall();
    }
}
