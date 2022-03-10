package commands;

import model.Flat;
import model.House;
import utils.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Class provides an opportunity to read, input and {@link Command#execute(Scanner, PrintStream, List)}
 */
public class ExecuteCommand implements Command {
    /**
     * all available command
     */
    private final LinkedHashMap<String, Command> commands;

    /**
     * Initializes a newly created ExecuteCommand object
     *
     * @param commands all available command
     */
    public ExecuteCommand(LinkedHashMap<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Receives the file name from the arguments.
     *
     * @param scanner scanner to enter additional arguments ( new {@link House},  {@link Flat})
     * @param out     out to display the result of the command
     * @param args    simple arguments to the command
     * @throws IllegalArgumentException  if invalid arguments
     * @throws IndexOutOfBoundsException if there are fewer arguments than required
     * @throws FileNotFoundException     if unable to open file
     */
    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws IllegalArgumentException,
            IndexOutOfBoundsException, FileNotFoundException {

        String fileName = Reader.readNotEmptyString(args.get(1));
        this.run(new Scanner(new File(fileName)), new PrintStream("log.txt"));

    }

    /**
     * Gets value of {@link Command#getName()} with arguments from input
     * Validates the input value
     * Calls a {@link Command#execute(Scanner, PrintStream, List)}  on each encountered {@link Command} from scanner ({@link File} or {@link System#in})
     *
     * @param scanner scanner reads {@link Command}
     * @param out     displays the suggestion to enter a value
     */
    public void run(Scanner scanner, PrintStream out) {

        out.print("> ");
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String commandName = str.split(" ")[0];

            if (commands.containsKey(commandName)) {
                try {
                    commands.get(commandName).execute(scanner, out, Arrays.asList(str.split(" ")));
                } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                    out.println("Invalid arguments");
                    out.print("> ");

                    continue;
                } catch (FileNotFoundException e) {
                    out.println("The file does not open or the file does not exist");
                    out.print("> ");

                    continue;
                }
            } else {
                out.println("No such command " + commandName.split(" ")[0]);
            }
            out.print("> ");
        }

    }


    /**
     * Returns the string name of this Command. The string name of this Command contains information that may be useful for key of {@link Hashtable} and for calling the {@link Command} from input
     *
     * @return string name of command
     */
    @Override
    public String getName() {
        return "execute_script";

    }

    /**
     * Returns the string description of this Command. The string description of a Command contains information that may be useful for  {@link HelpCommand#execute(Scanner, PrintStream, List)}
     *
     * @return The string description of this Command
     */
    @Override
    public String getDescription() {
        return "read and execute the script from the specified file. The script contains commands in the same form in which the user enters them interactively.";

    }
}
