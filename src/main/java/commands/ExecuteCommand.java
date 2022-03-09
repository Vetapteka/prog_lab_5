package commands;

import utils.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class ExecuteCommand implements Command {

    private final LinkedHashMap<String, Command> commands;

    public ExecuteCommand(LinkedHashMap<String, Command> commands) {
        this.commands = commands;

    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws IllegalArgumentException,
            IndexOutOfBoundsException, FileNotFoundException {

        String fileName = Reader.readNotEmptyString(args.get(1));
        this.run(new Scanner(new File(fileName)), new PrintStream("log.txt"));

    }


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


    @Override
    public String getName() {
        return "execute_script";

    }

    @Override
    public String getDescription() {
        return "read and execute the script from the specified file. The script contains commands in the same form in which the user enters them interactively.";

    }
}
