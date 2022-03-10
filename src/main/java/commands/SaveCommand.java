package commands;

import model.MyCollection;
import utils.Converter;

import java.io.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * the class contains methods for working with the command
 */
public class SaveCommand implements Command {
    /**
     * name of file
     */
    private final String fileName;
    /**
     * collection and data of initialization
     */
    private final MyCollection myCollection;

    /**
     * Initializes a newly created SaveCommand  object
     * @param myCollection collection + initialization date
     * @param filename name of file
     */
    public SaveCommand(MyCollection myCollection, String filename) {
        this.fileName = filename;
        this.myCollection = myCollection;
    }

    /**
     * save collection {@link MyCollection} to file
     * @param scanner scanner to enter additional arguments ( new {@link model.House},  {@link model.Flat})
     * @param out out to display the result of the command
     * @param args simple arguments to the command
     * @throws FileNotFoundException  if unable to open file
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws FileNotFoundException {

        Converter.toJson(myCollection, fileName);

    }
    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     * @return string name of command
     */
    @Override
    public String getName() {
        return "save";
    }
    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "save collection to file";
    }
}
