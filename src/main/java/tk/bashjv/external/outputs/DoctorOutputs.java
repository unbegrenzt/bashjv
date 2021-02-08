/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external.outputs;

import tk.bashjv.external.Bash;
import tk.bashjv.utils.enums.BashCommand;
import tk.bashjv.utils.factories.CommandsFactory;
import tk.bashjv.utils.intefaces.ConsoleCommands;

import java.io.IOException;

/**
 * The type Doctor outputs.
 * run the commands on the console for gets
 * the status of the dependencies
 */
public class DoctorOutputs {

    private static final ConsoleCommands consoleCommands = new CommandsFactory().getCommands();

    /**
     * Hyper status string.
     *
     * @return the string from the console
     * @throws IOException the io exception
     */
    public static String hyperStatus() throws IOException {
        return Bash.execute(consoleCommands.Command(BashCommand.HYPER_STATE));
    }
}