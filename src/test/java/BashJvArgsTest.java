import com.github.lalyos.jfiglet.FigletFont;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import tk.bashjv.service.Bashjv;

import static org.junit.jupiter.api.Assertions.*;

class BashJvArgsTest {

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
        String expected = FigletFont.convertOneLine("BashJv") + System.lineSeparator();
        String actual = sw.toString();

        assertEquals(0, exitCode);
        assertEquals(expected, actual);
    }

    @Test
    void bashjv_ArgVersion_PrintsVersionMessage() {
        int exitCode = cmd.execute("--version");
        String expected = "bashjv 1.0.0" + System.lineSeparator();
        String actual = sw.toString();

        assertEquals(0, exitCode);
        assertEquals(expected, actual);
    }

    @Test
    void bashjv_ArgHelp_PrintsHelpMessage() {
        int exitCode = cmd.execute("-h");
        String expected =
                "Usage: bashjv [-hV]" + System.lineSeparator() +
                "Setup and modify console for dev ops development" + System.lineSeparator() +
                "  -h, --help      Show this help message and exit." + System.lineSeparator() +
                "  -V, --version   Print version information and exit." + System.lineSeparator();
        String actual = sw.toString();

        assertEquals(0, exitCode);
        assertEquals(expected, actual);
    }
}