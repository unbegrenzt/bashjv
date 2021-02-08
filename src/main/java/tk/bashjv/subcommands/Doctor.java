/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.subcommands;

import org.fusesource.jansi.Ansi;
import picocli.CommandLine;
import tk.bashjv.external.BashGitLabRunner;
import tk.bashjv.external.outputs.DoctorOutputs;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * The type Doctor.
 * doctor console command for
 * get dependencies state and information
 */
@CommandLine.Command(name = "doctor",
        description = "Get dependencies state and information")
public class Doctor implements Callable<Integer> {
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() {
        try {
            String consoleOutput = DoctorOutputs.hyperStatus();
            Ansi output = BashGitLabRunner.getRunnerStatus(consoleOutput);
            spec.commandLine().getOut().println(output);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
