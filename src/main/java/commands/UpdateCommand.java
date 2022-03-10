package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.*;

/**
 * the class contains methods for working with the command
 */
public class UpdateCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created SaveCommand  object
     *
     * @param flats collection
     */
    public UpdateCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;

    }

    /**
     * update the value of the collection element whose id is equal to the given one
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link model.Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException  if invalid arguments
     * @throws IndexOutOfBoundsException if there are fewer arguments than required
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));

        if (flats.containsKey(id)) {
            flats.put(id, new Flat(scanner, id, out));
        } else {
            out.println("There are only such flats: ");
            Collections.list(flats.keys()).forEach(out::println);
        }
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "update";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "update the value of the collection element whose id is equal to the given one";
    }
}
