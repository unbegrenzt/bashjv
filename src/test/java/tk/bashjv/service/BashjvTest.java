/*
 * Develop by unbegrenzt at 2 - 2021.
 */

package tk.bashjv.service;

import com.github.lalyos.jfiglet.FigletFont;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.fusesource.jansi.Ansi.ansi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BashjvTest {

    private CommandLine cmd;
    private StringWriter sw;

    @BeforeEach
    void BeforeEach() {
        Bashjv bashJv = new Bashjv();
        cmd = new CommandLine(bashJv);
        sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));
    }

    @Test
    void bashjv_NoArguments_PrintsWelcomeMessage() throws IOException {
        int exitCode = cmd.execute();
        String expected = ansi().render(
                "@|blue " + FigletFont.convertOneLine("BashJv") + "|@" + System.lineSeparator()
        ).toString();
        String actual = sw.toString();

        assertEquals(0, exitCode);
        assertEquals(expected, actual);
    }

    @Test
    void bashjv_ArgVersion_PrintsVersionMessage() {
        int exitCode = cmd.execute("--version");
        assertEquals(0, exitCode);
    }

    @Test
    void bashjv_ArgHelp_PrintsHelpMessage() {
        int exitCode = cmd.execute("-h");
        assertEquals(0, exitCode);
    }
}