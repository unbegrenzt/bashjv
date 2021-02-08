/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external.outputs;

import tk.bashjv.external.Bash;
import tk.bashjv.utils.factories.CommandsFactory;
import tk.bashjv.utils.enums.BashCommand;
import tk.bashjv.utils.intefaces.ConsoleCommands;

import java.io.IOException;

/**
 * The type Gitlab runner outputs.
 * gets the gitlab runner status with
 * the default configuration
 */
public class GitlabRunnerOutputs {

    private static final ConsoleCommands consoleCommands = new CommandsFactory().getCommands();

    /**
     * Gitlab runner status string.
     *
     * @return the console outputs
     * @throws IOException the io exception
     */
    public static String gitlabRunnerStatus() throws IOException {
        return Bash.execute(consoleCommands.Command(BashCommand.HELM_NAMESPACES));
    }
}
