/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.external;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bash {

    public static String execute(String command) throws IOException {
        Process process = Runtime.getRuntime()
                .exec(command, null);
        return printResults(process);
    }

    private static String printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "",
                output = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            output = output.concat(line).concat(System.lineSeparator());
        }
        return output;
    }
}
