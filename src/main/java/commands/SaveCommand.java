package commands;

import model.MyCollection;
import utils.Converter;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class SaveCommand implements Command {

    private final String fileName;
    private final MyCollection myCollection;

    public SaveCommand(MyCollection myCollection, String filename) {
        this.fileName = filename;
        this.myCollection = myCollection;
    }


    @Override
    public void execute(Scanner scanner, PrintStream out, List<String> args) throws FileNotFoundException {

        Converter.toJson(myCollection, fileName);

    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save collection to file";
    }
}
