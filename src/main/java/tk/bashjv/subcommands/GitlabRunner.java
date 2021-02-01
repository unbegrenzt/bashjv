/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.subcommands;

import picocli.CommandLine.Spec;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Command;

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
    public Integer call() throws Exception {
        return 0;
    }

    @Command(name = "status",
            description = "Get the current status of the gitlab runner instance")
    int status(){
        spec.commandLine().getOut().println("");
        return 0;
    }
}
