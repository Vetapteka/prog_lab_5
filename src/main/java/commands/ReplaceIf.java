package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;


/**
 * the abstract class contains methods for working with the commands {@link ReplaceIfLowerCommand} {@link ReplaceIfGraterCommand}
 * Allows to replace the values of the collection according to the result of condition passed by the child
 */
public abstract class ReplaceIf implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created ReplaceIfCommand  object
     *
     * @param flats collection
     */

    public ReplaceIf(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * replaces the value of collection {@link model.MyCollection} provided by the return method {@link ReplaceIf#checkCompareResult(int)}
     *
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link Flat})
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
            Flat newFlat = new Flat(scanner, id, out);
            int compareRes = newFlat.compareTo(flats.get(id));

            if (checkCompareResult(compareRes)) {
                flats.replace(id, newFlat);
            }

        } else out.println("no such flat");
    }

    /**
     * @param compareResult result of comparing two indices
     * @return more (true) or less (false)
     */
    abstract boolean checkCompareResult(int compareResult);
}
