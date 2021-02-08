/*
 * Develop by unbegrenzt at 2 - 2021.
 */
package tk.bashjv.service;

import com.github.lalyos.jfiglet.FigletFont;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Command;
import tk.bashjv.subcommands.Doctor;
import tk.bashjv.subcommands.GitlabRunner;

import static org.fusesource.jansi.Ansi.*;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Create the bashjv command and it's default
 * arguments
 * <p>
 * The {@link Command} object creates the name,
 * declares the version name and the description.
 * </p>
 */
@Command(name = "bashjv", mixinStandardHelpOptions = true, version = "bashjv 1.0.0",
        description = "Setup and modify console for dev ops development",
        subcommands = {
                GitlabRunner.class,
                Doctor.class
        })
public class Bashjv implements Callable<Integer> {
    /**
     * The Spec.
     */
    @Spec
    CommandSpec spec;

    @Override
    public Integer call() throws IOException {
        AnsiConsole.systemInstall();
        Ansi helloMessage = ansi().render("@|blue " + FigletFont.convertOneLine("BashJv") + "|@");
        spec.commandLine().getOut().println(helloMessage);
        return 0;
    }

    /**
     * The entry point of application.
     * shows a welcome message from console
     * @param args the input arguments
     */
    public static void main(String... args) {
        int exitCode = new CommandLine(new Bashjv()).execute(args);
        System.exit(exitCode);
    }
}

