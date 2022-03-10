package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class InsertCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created InsertCommand  object
     *
     * @param flats collection
     */
    public InsertCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * adds a new value to the collection {@link model.MyCollection} if it doesn't already exist
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException  of invalid argument
     * @throws IndexOutOfBoundsException if there are fewer arguments than required
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));
        if (flats.containsKey(id)) {
            out.println("the key already exists");
            return;
        }
        flats.put(id, new Flat(scanner, id, out));
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "insert";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "add new element with given key";
    }
}
