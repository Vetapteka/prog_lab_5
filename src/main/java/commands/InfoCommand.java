package commands;

import model.Flat;
import model.House;
import model.MyCollection;

import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class InfoCommand implements Command {
    /**
     * collection
     */
    private final Hashtable<Integer, Flat> flats;
    /**
     * date of initialization
     */
    private final Date date;

    /**
     * Initializes a newly created InfoCommand object
     *
     * @param flats collection
     * @param date  date of initialization
     */
    public InfoCommand(Hashtable<Integer, Flat> flats, Date date) {
        this.flats = flats;
        this.date = date;
    }

    /**
     * print information about the {@link MyCollection} to the standard output stream (type, initialization date, number of elements, etc.)
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {

        out.println("type: " + flats.getClass().toString());
        out.println("initialization date: " + date.toString());
        out.println("info of elements: " + flats.size());
    }

    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "print information about the collection to the standard output stream (type, initialization date, number of elements, etc.)";
    }
}
