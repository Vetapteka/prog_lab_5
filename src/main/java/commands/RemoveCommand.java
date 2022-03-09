package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class RemoveCommand implements Command {
    private final Hashtable<Integer, Flat> flats;

    public RemoveCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer arg = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));
        flats.remove(arg);

    }

    @Override
    public String getName() {
        return "remove";
    }

    @Override
    public String getDescription() {
        return "remove an element from a collection by its key";
    }
}
