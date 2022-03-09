package commands;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public interface Command {
    void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, FileNotFoundException;

    String getName();

    String getDescription();
}
