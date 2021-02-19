/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.junit.jupiter.api.Test;

import static org.fusesource.jansi.Ansi.ansi;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BashDoctorTest {

    @Test
    void hyperStatus_EnabledState_EnabledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Hyper-v -- @|GREEN Enabled |@"
        ).toString();
        String actual = BashDoctor.getHyperStatus(
                "FeatureName      : Microsoft-Hyper-V" + System.lineSeparator() +
                        "DisplayName      : Platform's de Hyper-V" + System.lineSeparator() +
                        "Description      : Proportions los service's" + System.lineSeparator() +
                        "RestartRequired  : Possible" + System.lineSeparator() +
                        "State            : Enabled" + System.lineSeparator() +
                        "CustomProperties : "
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void hyperStatus_DisabledState_DisabledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Hyper-v -- @|RED Disabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "Use pwsh -- " +
                        "@|BLUE Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All |@" +
                        "Command"
        ).toString();
        String actual = BashDoctor.getHyperStatus(
                "FeatureName      : Microsoft-Hyper-V" + System.lineSeparator() +
                        "DisplayName      : Platform's de Hyper-V" + System.lineSeparator() +
                        "Description      : Proportions los service's" + System.lineSeparator() +
                        "RestartRequired  : Possible" + System.lineSeparator() +
                        "State            : Disabled" + System.lineSeparator() +
                        "CustomProperties : "
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void wslStatus_EnabledState_EnabledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@WSL -- @|GREEN Enabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE docs.microsoft.com/en-us/windows/wsl/install-win10 |@" +
                        "website" + System.lineSeparator() +
                        "@|CYAN  !_ |@" +
                        "Use -- " +
                        "@|BLUE wsl version 2 |@"
        ).toString();
        String actual = BashDoctor.getWslStatus(
                "FeatureName      : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                        "DisplayName      : Subsystem de Windows para Linux" + System.lineSeparator() +
                        "Description      : Proportion services y enormous " + System.lineSeparator() +
                        "para ejecta Merriment's y shells de Linux " + System.lineSeparator() +
                        "de mod de usurious native " + System.lineSeparator() +
                        "                   en Windows." + System.lineSeparator() +
                        "RestartRequired  : Possible" + System.lineSeparator() +
                        "State            : Enabled" + System.lineSeparator() +
                        "CustomProperties :" + System.lineSeparator() +
                        "   ServerComponent\\Description : Proportion services" +
                        " y enormous para ejecta Merriment's y shells de " + System.lineSeparator() +
                        "   Linux de mod de usurious native en Windows." + System.lineSeparator() +
                        "   ServerComponent\\DisplayName : Subsystem de Windows para Linux" + System.lineSeparator() +
                        "   ServerComponent\\Id : 1033" + System.lineSeparator() +
                        "   ServerComponent\\Type : Feature" + System.lineSeparator() +
                        "   ServerComponent\\UniqueName : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                        "   ServerComponent\\Deploys\\\\Update\\\\Name : " + System.lineSeparator() +
                        "Microsoft-Windows-Subsystem-Linux"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void wslStatus_DisabledState_DisabledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@WSL -- @|RED Disabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE docs.microsoft.com/en-us/windows/wsl/install-win10 |@" +
                        "website"
        ).toString();
        String actual = BashDoctor.getWslStatus(
                "FeatureName      : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                        "DisplayName      : Subsystem de Windows para Linux" + System.lineSeparator() +
                        "Description      : Proportion services y enormous " + System.lineSeparator() +
                        "para ejecta Merriment's y shells de Linux " + System.lineSeparator() +
                        "de mod de usurious native " + System.lineSeparator() +
                        "                   en Windows." + System.lineSeparator() +
                        "RestartRequired  : Possible" + System.lineSeparator() +
                        "State            : Disabled" + System.lineSeparator() +
                        "CustomProperties :" + System.lineSeparator() +
                        "   ServerComponent\\Description : Proportion services" +
                        " y enormous para ejecta Merriment's y shells de " + System.lineSeparator() +
                        "   Linux de mod de usurious native en Windows." + System.lineSeparator() +
                        "   ServerComponent\\DisplayName : Subsystem de Windows para Linux" + System.lineSeparator() +
                        "   ServerComponent\\Id : 1033" + System.lineSeparator() +
                        "   ServerComponent\\Type : Feature" + System.lineSeparator() +
                        "   ServerComponent\\UniqueName : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                        "   ServerComponent\\Deploys\\\\Update\\\\Name : " + System.lineSeparator() +
                        "Microsoft-Windows-Subsystem-Linux"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getDockerKubStatus_DisabledNotRunning_InstallResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Docker -- @|RED Disabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE https://www.docker.com/get-started |@"
        ).toString();
        String actual = BashDoctor.getDockerKubStatus(
                "error during connect: In the default daemon configuration" +
                        "on Windows, the docker client must be run with elevated" +
                        "privileges to connect.: Get http://%2F%2F.%2Fpipe%2Fdocker" +
                        "_engine/v1.24/version: open //./pipe/docker_engine: El " +
                        "system no peed encounter el archive especial."
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getDockerKubStatus_EnabledNotRunning_NotRunningResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Docker -- @|RED Not Running |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "Kubernetes -- " +
                        "@|RED Not Running |@" + System.lineSeparator() +
                        "@|CYAN  !_ |@" +
                        "Recommended -- " +
                        "@|BLUE Start docker server |@"
        ).toString();
        String actual = BashDoctor.getDockerKubStatus(
                "Client: Docker Engine - Community" + System.lineSeparator() +
                        " Cloud integration: 1.0.7" + System.lineSeparator() +
                        " Version:           20.10.2" + System.lineSeparator() +
                        " API version:       1.41" + System.lineSeparator() +
                        " Go version:        go1.13.15" + System.lineSeparator() +
                        " Git commit:        2291f61" + System.lineSeparator() +
                        " Built:             Mon Dec 28 16:14:16 2020" + System.lineSeparator() +
                        " OS/Arch:           windows/amd64" + System.lineSeparator() +
                        " Context:           default" + System.lineSeparator() +
                        " Experimental:      true" + System.lineSeparator() +
                        "error during connect: In the default daemon configuration" +
                        "on Windows, the docker client must be run with elevated" +
                        "privileges to connect.: Get http://%2F%2F.%2Fpipe%2Fdocker" +
                        "_engine/v1.24/version: open //./pipe/docker_engine: El " +
                        "system no peed encounter el archive especial."
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getDockerKubStatus_RunningNotRunningKub_MixedResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Docker -- @|GREEN Running |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "Kubernetes -- " +
                        "@|RED Not Running |@" + System.lineSeparator() +
                        "@|CYAN  !_ |@" +
                        "Recommended -- " +
                        "@|BLUE Start Kubernetes |@"
        ).toString();
        String actual = BashDoctor.getDockerKubStatus(
                "Client: Docker Engine - Community" + System.lineSeparator() +
                        " Cloud integration: 1.0.7" + System.lineSeparator() +
                        " Version:           20.10.2" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Server: Docker Engine - Community" + System.lineSeparator() +
                        " Engine:" + System.lineSeparator() +
                        "  Version:          20.10.2" + System.lineSeparator() +
                        "  API version:      1.41 (minimum version 1.12)" + System.lineSeparator() +
                        "  Go version:       go1.13.15" + System.lineSeparator() +
                        "  Git commit:       8891c58"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getDockerKubStatus_AllRunning_RunningResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Docker -- @|GREEN Running |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "Kubernetes -- " +
                        "@|GREEN Running |@"
        ).toString();
        String actual = BashDoctor.getDockerKubStatus(
                "Client: Docker Engine - Community" + System.lineSeparator() +
                        " Cloud integration: 1.0.7" + System.lineSeparator() +
                        " Version:           20.10.2" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Server: Docker Engine - Community" + System.lineSeparator() +
                        " Engine:" + System.lineSeparator() +
                        "  Version:          20.10.2" + System.lineSeparator() +
                        "  API version:      1.41 (minimum version 1.12)" + System.lineSeparator() +
                        "  Go version:       go1.13.15" + System.lineSeparator() +
                        "Kubernetes:" + System.lineSeparator() +
                        "  Version:          v1.19.3" + System.lineSeparator() +
                        "  StackAPI:         Unknown" + System.lineSeparator() +
                        "  Git commit:       8891c58"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getHelmStatus_GetVersion_installedResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Helm -- @|GREEN Installed |@"
        ).toString();
        String actual = BashDoctor.getHelmStatus(
                        "version.BuildInfo{Version:\"v3.5.0\", " +
                        "GitCommit:\"32c22239423b3b4ba6706d450bd044baffled9e6\", " +
                        "GitTreeState:\"clean\", " +
                        "GoVersion:\"go1.15.6\"}"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getHelmStatus_Throws_NotInstalledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Helm -- @|RED Not Installed |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE https://helm.sh/docs/intro/quickstart/ |@"
        ).toString();
        String actual = BashDoctor.getHelmStatus(
                "aside: The term 'aside' is not recognized as a name of a" +
                        " cmdlet, function, script file, or executable program." + System.lineSeparator() +
                        "Check the spelling of the name, or if a path was included" +
                        ", verify that the path is correct and try again."
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getPwshStatus_GetVersion_InstalledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@PowerShell Core -- @|GREEN Installed |@"
        ).toString();
        String actual = BashDoctor.getPwshStatus(
                "PowerShell 7.1.1"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getPwshStatus_Throws_NotInstalledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@PowerShell Core -- @|RED Not Installed |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE https://github.com/PowerShell/PowerShell |@"
        ).toString();
        String actual = BashDoctor.getPwshStatus(
                "Error command not found"
        ).toString();
        assertEquals(expected, actual);
    }
}
