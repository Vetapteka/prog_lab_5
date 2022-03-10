package commands;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class ExitCommand implements Command {
    /**
     * Terminate program (without saving to file)
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link model.Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        System.exit(0);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "terminate program (without saving to file)";
    }
}
