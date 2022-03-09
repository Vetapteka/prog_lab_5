package commands;

import model.Flat;

import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class InfoCommand implements Command {

    private final Hashtable<Integer, Flat> flats;
    private final Date date;

    public InfoCommand(Hashtable<Integer, Flat> flats, Date date) {
        this.flats = flats;
        this.date = date;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {

        out.println("type: " + flats.getClass().toString());
        out.println("initialization date: " + date.toString());
        out.println("info of elements: " + flats.size());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "print information about the collection to the standard output stream (type, initialization date, number of elements, etc.)";
    }
}
