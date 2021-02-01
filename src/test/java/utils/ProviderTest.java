/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import tk.bashjv.utils.OsSystem;
import tk.bashjv.utils.Provider;

import static org.junit.jupiter.api.Assertions.*;

public class ProviderTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void onlyOnWindows() {
        OsSystem expected = OsSystem.WINDOWS;
        OsSystem actual = Provider.currentOsSystem();

        assertEquals(expected, actual);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {
        OsSystem expected = OsSystem.MAC;
        OsSystem actual = Provider.currentOsSystem();

        assertEquals(expected, actual);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void onlyOnMacLinux() {
        OsSystem expected = OsSystem.LINUX;
        OsSystem actual = Provider.currentOsSystem();

        assertEquals(expected, actual);
    }
}
