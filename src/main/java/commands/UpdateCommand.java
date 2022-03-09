package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.*;

public class UpdateCommand implements Command {
    private final Hashtable<Integer, Flat> flats;


    public UpdateCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;

    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));

        if (flats.containsKey(id)) {
            flats.put(id, new Flat(scanner, id, out));
        } else {
            out.println("There are only such flats: ");
            Collections.list(flats.keys()).forEach(out::println);
        }
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "update the value of the collection element whose id is equal to the given one";
    }
}
