/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.subcommands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;
import tk.bashjv.service.Bashjv;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorTest {

    private CommandLine cmd;

    @BeforeEach
    void BeforeEach() {
        Bashjv bashJv = new Bashjv();
        cmd = new CommandLine(bashJv);
    }

    @Test
    void call_execute_ExitCodeZero() {
        int exitCode = cmd.execute("doctor");
        assertEquals(0, exitCode);
    }
}
