package commands;

import model.Flat;
import model.FurnishComparator;
import model.House;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class PrintFiledCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created PrintFiledCommand  object
     *
     * @param flats collection
     */

    public PrintFiledCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * print the {@link model.Furnish} field values of all elements in descending order
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        flats.keySet().stream().map(x -> flats.get(x).getFurnish()).sorted(new FurnishComparator()).forEach(out::println);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "print_field_descending_furnish";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "print the furnish field values of all elements in descending order";
    }
}
