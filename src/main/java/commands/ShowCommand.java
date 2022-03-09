package commands;

import model.Flat;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class ShowCommand implements Command {
    private final Hashtable<Integer, Flat> flats;

    public ShowCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        flats.keySet().stream().map(flats::get).forEach(out::println);
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "print to standard output all elements of the collection in string representation";

    }
}
