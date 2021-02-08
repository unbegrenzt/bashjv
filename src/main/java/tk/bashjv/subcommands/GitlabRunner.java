/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.subcommands;

import org.fusesource.jansi.Ansi;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Command;
import tk.bashjv.external.BashGitLabRunner;
import tk.bashjv.external.outputs.GitlabRunnerOutputs;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Run the gitlab_runner app into a kubernetes cluster
 * by using helm with the user configuration
 * <p>
 * see more:
 *  <a href="https://docs.gitlab.com/runner/install/kubernetes.html">
 *      install gitlab runner kubernetes
 *  </a>
 * </p>
 */
@Command(name = "gitlabRunner",
        description = "Installs, setup your personalized gitlab runner instance")
public class GitlabRunner implements Callable<Integer> {
    @Spec CommandSpec spec;

    @Override
    public Integer call() {
        return 0;
    }

    @Command(name = "status",
            description = "Get the current status of the gitlab runner instance")
    int status() {
        try {
            String consoleOutput = GitlabRunnerOutputs.gitlabRunnerStatus();
            Ansi output = BashGitLabRunner.getRunnerStatus(consoleOutput);
            spec.commandLine().getOut().println(output);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}