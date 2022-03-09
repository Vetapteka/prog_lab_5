package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveGreaterKeyCommand implements Command {
    private final Hashtable<Integer, Flat> flats;

    public RemoveGreaterKeyCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));
        List<Integer> filterList = flats.keySet().stream().filter(x -> x > id).collect(Collectors.toList());
        filterList.forEach(flats::remove);
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getDescription() {
        return "remove from the collection all elements whose key is greater than the given one";
    }
}
