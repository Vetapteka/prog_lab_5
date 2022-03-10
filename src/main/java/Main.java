import commands.*;
import model.Flat;
import model.MyCollection;
import utils.Converter;
import utils.Reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;


/**
 * main class
 */
public class Main {

    /**
     * @param args - file name can be passed here
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        MyCollection myCollection = null;

        String fileName = (args.length > 0) ? Reader.readFileName(args[0]) : "db.json";
        try {
            myCollection = Converter.fromJson(fileName);
        } catch (IOException e) {
            out.println("invalid file or file name");
            System.exit(0);
        }

        assert myCollection != null;
        Hashtable<Integer, Flat> flats = myCollection.getCollection();

        Invoker invoker = new Invoker(scanner, out, myCollection, fileName);
        invoker.run();
    }

}
