package commands;

import model.Flat;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class ReplaceIfLowerCommand extends ReplaceIf {
    /**
     * Initializes a newly created ReplaceIfLowerCommand  object
     *
     * @param flats collection
     */
    public ReplaceIfLowerCommand(Hashtable<Integer, Flat> flats) {
        super(flats);
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "replace_if_lower";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "replace the value by key if the new value is less than the old one";
    }

    /**
     * @param compareResult result of comparing two indices
     * @return true if arg < element of collection
     */
    @Override
    boolean checkCompareResult(int compareResult) {
        return compareResult < 0;
    }
}


