/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils.factories;

import tk.bashjv.utils.classes.LinuxCommands;
import tk.bashjv.utils.classes.MacCommands;
import tk.bashjv.utils.classes.Provider;
import tk.bashjv.utils.classes.WinCommands;
import tk.bashjv.utils.intefaces.ConsoleCommands;

/**
 * The type Commands factory.
 */
public class CommandsFactory {

    /**
     * Gets commands.
     *
     * @return the commands for the current os system
     */
    public ConsoleCommands getCommands() {
        return switch (Provider.currentOsSystem()) {
            case MAC -> new MacCommands();
            case LINUX -> new LinuxCommands();
            case WINDOWS -> new WinCommands();
            default -> null;
        };
    }
}
