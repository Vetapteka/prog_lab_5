package commands;

import model.Flat;
import model.House;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * the class contains methods for working with the command
 */
public class RemoveGreaterKeyCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created RemoveGreaterKeyCommand  object
     *
     * @param flats collection
     */
    public RemoveGreaterKeyCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * remove from the collection {@link model.MyCollection} all elements whose key is greater than the given one
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException  if invalid arguments
     * @throws IndexOutOfBoundsException if there are fewer arguments than required
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));
        List<Integer> filterList = flats.keySet().stream().filter(x -> x > id).collect(Collectors.toList());
        filterList.forEach(flats::remove);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "remove_greater_key";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "remove from the collection all elements whose key is greater than the given one";
    }
}
