/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package external;

import org.junit.jupiter.api.Test;
import tk.bashjv.external.BashDoctor;

import static org.fusesource.jansi.Ansi.ansi;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BashDoctorTest {

    @Test
    void hyperStatus_EnabledState_EnabledResponse() {
        String expected = ansi().render(
                "@|CYAN * |@ Hyper-v -- @|GREEN Enabled |@"
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
        System.out.println(expected);
        String actual = BashDoctor.getWslStatus(
                "FeatureName      : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                        "DisplayName      : Subsistema de Windows para Linux" + System.lineSeparator() +
                        "Description      : Proporciona servicios y entornos " + System.lineSeparator() +
                        "para ejecutar herramientas y shells de Linux " + System.lineSeparator() +
                        "de modo de usuario nativo " + System.lineSeparator() +
                        "                   en Windows." + System.lineSeparator() +
                        "RestartRequired  : Possible" + System.lineSeparator() +
                        "State            : Enabled" + System.lineSeparator() +
                        "CustomProperties :" + System.lineSeparator() +
                        "   ServerComponent\\Description : Proporciona servicios" +
                        " y entornos para ejecutar herramientas y shells de " + System.lineSeparator() +
                        "   Linux de modo de usuario nativo en Windows." + System.lineSeparator() +
                        "   ServerComponent\\DisplayName : Subsistema de Windows para Linux" + System.lineSeparator() +
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
        System.out.println(expected);
        String actual = BashDoctor.getWslStatus(
                "FeatureName      : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                "DisplayName      : Subsistema de Windows para Linux" + System.lineSeparator() +
                "Description      : Proporciona servicios y entornos " + System.lineSeparator() +
                        "para ejecutar herramientas y shells de Linux " + System.lineSeparator() +
                        "de modo de usuario nativo " + System.lineSeparator() +
                "                   en Windows." + System.lineSeparator() +
                "RestartRequired  : Possible" + System.lineSeparator() +
                "State            : Disabled" + System.lineSeparator() +
                "CustomProperties :" + System.lineSeparator() +
                "   ServerComponent\\Description : Proporciona servicios" +
                        " y entornos para ejecutar herramientas y shells de " + System.lineSeparator() +
                "   Linux de modo de usuario nativo en Windows." + System.lineSeparator() +
                "   ServerComponent\\DisplayName : Subsistema de Windows para Linux" + System.lineSeparator() +
                "   ServerComponent\\Id : 1033" + System.lineSeparator() +
                "   ServerComponent\\Type : Feature" + System.lineSeparator() +
                "   ServerComponent\\UniqueName : Microsoft-Windows-Subsystem-Linux" + System.lineSeparator() +
                "   ServerComponent\\Deploys\\\\Update\\\\Name : " + System.lineSeparator() +
                        "Microsoft-Windows-Subsystem-Linux"
        ).toString();
        assertEquals(expected, actual);
    }
}
