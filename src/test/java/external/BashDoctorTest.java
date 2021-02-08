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
}
