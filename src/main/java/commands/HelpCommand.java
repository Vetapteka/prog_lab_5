package commands;

import model.Flat;
import model.House;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class HelpCommand implements Command {
    /**
     * all available commands
     */
    private final LinkedHashMap<String, Command> commands;

    /**
     * Initializes a newly created HelpCommand object
     *
     * @param commands all available commands
     */
    public HelpCommand(LinkedHashMap<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * call the {@link Command#getDescription()} for all commands in collection of {@link model.MyCollection}
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        commands.forEach((k, v) -> out.println(k + " - " + v.getDescription()));
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    public String getName() {
        return "help";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "display help on available commands";
    }

}
