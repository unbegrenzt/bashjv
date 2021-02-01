/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils;

public class Provider {

    public static OsSystem currentOsSystem() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return OsSystem.WINDOWS;

        } else if (os.contains("osx")) {
            return OsSystem.LINUX;

        } else if (os.contains("nix") || os.contains("aix") || os.contains("nux")) {
            return OsSystem.MAC;

        }
        return OsSystem.ERROR;
    }
}
