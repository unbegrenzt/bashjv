/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import org.junit.jupiter.api.Test;

import static org.fusesource.jansi.Ansi.ansi;
import static org.junit.jupiter.api.Assertions.*;

public class BashGitlabRunnerTest {

    @Test
    void getRunnerStatus_DeployedStatus_RunningResponse() {
        String expected = ansi().render("@|CYAN * |@Gitlab runner -- @|GREEN Running |@").toString();
        String actual = BashGitLabRunner.getRunnerStatus(
                "NAME      NAMESPACE         REVISION" + System.lineSeparator() +
                        "gitlab-runner gitlab-runner-din 1       " + System.lineSeparator() +
                        "UPDATED                               STATUS   CHART" + System.lineSeparator() +
                        "2021-02-05 11:03:10.8142606 -0600 CST deployed gitlab-runner-0.25.0" + System.lineSeparator() +
                        "APP VERSION" + System.lineSeparator() +
                        "13.8.0"
        ).toString();
        assertEquals(expected, actual);
    }

    @Test
    void getRunnerStatus_UndeployStatus_NotRunningResponse() {
        String expected = ansi().render(
                "@|CYAN * |@Gitlab runner -- @|RED Disabled |@" + System.lineSeparator() +
                        "@|CYAN  \\_ |@" +
                        "See more -- " +
                        "@|BLUE https://docs.gitlab.com/runner/install/kubernetes.html use *gitlab-runner* namespace |@"
        ).toString();
        String actual = BashGitLabRunner.getRunnerStatus(
                "NAME    NAMESPACE       REVISION        UPDATED STATUS  CHART   APP VERSION"
        ).toString();
        assertEquals(expected, actual);
    }
}
