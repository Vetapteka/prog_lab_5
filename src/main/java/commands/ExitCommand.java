package commands;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ExitCommand implements Command {

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "terminate program (without saving to file)";
    }
}
