package commands;

import model.Flat;
import model.FurnishComparator;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class PrintFiledCommand implements Command{

    private final Hashtable<Integer, Flat> flats;

    public PrintFiledCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
    flats.keySet().stream().map(x -> flats.get(x).getFurnish()).sorted(new FurnishComparator()).forEach(out::println);
    }

    @Override
    public String getName() {
        return "print_field_descending_furnish";
    }

    @Override
    public String getDescription() {
        return "print the furnish field values of all elements in descending order";
    }
}
