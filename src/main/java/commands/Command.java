package commands;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the interface contains methods for working with the command
 */
public interface Command {
    /**
     * execute command
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link model.Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException if invalid arguments
     * @throws FileNotFoundException    if unable to open file
     */
    void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, FileNotFoundException;

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    String getName();

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    String getDescription();
}
