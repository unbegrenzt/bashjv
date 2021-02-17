/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import tk.bashjv.utils.classes.EnvVars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The type Bash.
 * is the class for access to the
 * bash of the system.
 */
public class Bash {

    private static final Boolean isDevelopment = EnvVars.isDev();

    /**
     * Execute string.
     *
     * @param command the command                to execute to the bash
     * @return the string output of the bash
     * @throws IOException the io exception if can't access to the console
     */
    public static String execute(String command) throws IOException {
        Process process = Runtime.getRuntime()
                .exec(command, null);
        return printResults(process);
    }

    private static String printResults(Process process) throws IOException {
        String line,
                output = "";

        if (isDevelopment)
            System.out.println("Standard Output:");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                process.getInputStream()));
        while ((line = stdout.readLine()) != null) {
            if (isDevelopment)
                System.out.println(line);
            output = output.concat(line).concat(System.lineSeparator());
        }
        stdout.close();

        if (isDevelopment)
            System.out.println("Standard Error:");
        BufferedReader stderr = new BufferedReader(new InputStreamReader(
                process.getErrorStream()));
        while ((line = stderr.readLine()) != null) {
            if (isDevelopment)
                System.out.println(line);
            output = output.concat(line).concat(System.lineSeparator());
        }
        stderr.close();
        if (isDevelopment)
            System.out.println("Done");

        return output;
    }
}
