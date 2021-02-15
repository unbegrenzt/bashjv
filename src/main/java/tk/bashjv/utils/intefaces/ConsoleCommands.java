/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils.intefaces;

import tk.bashjv.utils.enums.BashCommand;

/**
 * The interface Console commands.
 * Used for the {@link tk.bashjv.utils.factories.CommandsFactory} class
 */
public interface ConsoleCommands {
    /**
     * Command string.
     *
     * @param bashCommand the bash command
     * @return the string
     */
    String Command(BashCommand bashCommand);
}
