package commands;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class HelpCommand implements Command {

    private final LinkedHashMap<String, Command> commands;

    public HelpCommand(LinkedHashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        commands.forEach((k, v) -> out.println( k + " - " +  v.getDescription()));
    }

    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "display help on available commands";
    }

}
