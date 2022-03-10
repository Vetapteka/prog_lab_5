package commands;

import model.Flat;
import model.House;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class CountByHouseCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;

    /**
     * Initializes a newly created CountByHouseCommand object
     *
     * @param flats collection
     */
    public CountByHouseCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    /**
     * prints the number of {@link House} whose values are equal to the value from the input
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        House house = new House(scanner, out);

        long count = flats.values().stream().map(Flat::getHouse)
                .filter(x -> x != null && x.compare(house)).count();
        out.println("There are " + count + " such houses.");

    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "count_by_house";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "display the number of elements whose house field value is equal to the given one";
    }

}
