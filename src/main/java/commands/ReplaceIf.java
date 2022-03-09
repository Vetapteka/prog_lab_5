package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public abstract class ReplaceIf implements Command {

    private final Hashtable<Integer, Flat> flats;



    public ReplaceIf(Hashtable<Integer, Flat> flats) {
        this.flats = flats;

    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));

        if (flats.containsKey(id)) {
            Flat newFlat = new Flat(scanner, id, out);
            int compareRes = newFlat.compareTo(flats.get(id));

            if (checkCompareResult(compareRes)) {
                flats.replace(id, newFlat);
            }

        } else out.println("no such flat");
    }

    abstract boolean checkCompareResult(int compareResult);
}
