package commands;

import model.Flat;
import utils.Reader;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class InsertCommand implements Command {

    private final Hashtable<Integer, Flat> flats;


    public InsertCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }


    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args)
            throws IllegalArgumentException, IndexOutOfBoundsException {

        Integer id = (Integer) Reader.readParsebleNumber(Integer::parseInt, args.get(1));
        if (flats.containsKey(id)){
            out.println("the key already exists");
            return;
        }
        flats.put(id, new Flat(scanner, id, out));
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "add new element with given key";
    }
}
