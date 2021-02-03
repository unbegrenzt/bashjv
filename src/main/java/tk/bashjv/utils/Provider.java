/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils;

/**
 * The type Provider.
 * class to access to the os info
 */
public class Provider {

    /**
     * Get the current os.
     *
     * @return the os system
     */
    public static OsSystem currentOsSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return OsSystem.WINDOWS;

        } else if (os.contains("osx")) {
            return OsSystem.MAC;

        } else if (os.contains("nix") || os.contains("aix") || os.contains("nux")) {
            return OsSystem.LINUX;

        }
        return OsSystem.ERROR;
    }
}
