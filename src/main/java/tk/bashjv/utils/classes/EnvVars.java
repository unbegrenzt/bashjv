/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.utils.classes;

/**
 * The type Env vars.
 */
public class EnvVars {

    /**
     * Is dev boolean.
     *
     * @return true if the BASHJV_ENVIRONMENT environment
     * variable is equal Development
     */
    public static Boolean isDev() {

        String envVar;

        try {
            envVar = System.getenv("BASHJV_ENVIRONMENT");
        } catch (Exception ignored) {
            envVar = "Production";
        }

        assert envVar != null;
        return envVar.equals("Development");
    }
}
