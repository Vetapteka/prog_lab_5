package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class FilterStartNameCommand implements Command {


    private final Hashtable<Integer, Flat> flats;

    public FilterStartNameCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws IllegalArgumentException, IndexOutOfBoundsException {
        String str = Reader.readNotEmptyString(args.get(1));
        flats.keySet().stream().map(flats::get).filter(x -> x.getName().startsWith(args.get(1))).forEach(out::println);
    }

    @Override
    public String getName() {
        return "filter_starts_with_name";
    }

    @Override
    public String getDescription() {
        return "display elements whose name field value starts with the given substring";
    }
}
