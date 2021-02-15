/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import tk.bashjv.utils.factories.CommandsFactory;
import tk.bashjv.utils.classes.LinuxCommands;
import tk.bashjv.utils.classes.MacCommands;
import tk.bashjv.utils.classes.WinCommands;
import tk.bashjv.utils.intefaces.ConsoleCommands;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandsFactoryTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void new_OnWindows_returnsInstance() {
        CommandsFactory commandsFactory = new CommandsFactory();
        ConsoleCommands actual = commandsFactory.getCommands();
        assertTrue(actual instanceof WinCommands);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void new_OnMac_returnsInstance() {
        CommandsFactory commandsFactory = new CommandsFactory();
        ConsoleCommands actual = commandsFactory.getCommands();
        assertTrue(actual instanceof MacCommands);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void new_onWindows_returnsInstance() {
        CommandsFactory commandsFactory = new CommandsFactory();
        ConsoleCommands actual = commandsFactory.getCommands();
        assertTrue(actual instanceof LinuxCommands);
    }
}
