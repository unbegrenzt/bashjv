/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.subcommands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;
import tk.bashjv.external.BashDoctor;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * The type Doctor.
 * doctor console command for
 * get dependencies state and information
 */
@Command(name = "doctor",
        description = "Get dependencies state and information")
public class Doctor implements Callable<Integer> {
    @Spec
    CommandSpec spec;

    @Override
    public Integer call() {
        try {
            BashDoctor.getDoctor(spec);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
