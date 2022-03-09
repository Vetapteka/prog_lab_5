package commands;

import model.Flat;
import model.House;

import java.io.PrintStream;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class CountByHouseCommand implements Command {

    private final Hashtable<Integer, Flat> flats;

    public CountByHouseCommand(Hashtable<Integer, Flat> flats) {
        this.flats = flats;
    }

    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) {
        House house = new House(scanner, out);

        long count = flats.values().stream().map(Flat::getHouse)
                .filter(x -> x != null && x.compare(house)).count();
        out.println("There are " + count + " such houses.");

    }

    @Override
    public String getName() {
        return "count_by_house";
    }

    @Override
    public String getDescription() {
        return "display the number of elements whose house field value is equal to the given one";
    }

}
