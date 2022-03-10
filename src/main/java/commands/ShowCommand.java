package commands;

import model.Flat;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class ShowCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created ShowCommand  object
     *
     * @param flats collection
     */
    public ShowCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * print to standard output all elements of the collection in string representation
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link model.Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        flats.keySet().stream().map(flats::get).forEach(out::println);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "print to standard output all elements of the collection in string representation";

    }
}
