package commands;

import model.Flat;
import model.House;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class FilterStartNameCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created FilterStartNameCommand  object
     *
     * @param flats collection
     */
    public FilterStartNameCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * display elements whose name field value starts with the given substring
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException  if invalid arguments
     * @throws IndexOutOfBoundsException if there are fewer arguments than required
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws IllegalArgumentException, IndexOutOfBoundsException {
        String str = Reader.readNotEmptyString(args.get(1));
        flats.keySet().stream().map(flats::get).filter(x -> x.getName().startsWith(args.get(1))).forEach(out::println);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "filter_starts_with_name";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "display elements whose name field value starts with the given substring";
    }
}
