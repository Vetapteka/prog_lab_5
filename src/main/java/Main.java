import commands.*;
import model.Flat;
import model.MyCollection;
import utils.Converter;

import java.io.PrintStream;
import java.util.*;


/**
 * main class
 */
public class Main {

    /**
     *
     * @param args - file name can be passed here
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        MyCollection myCollection = null;

        String fileName = (args.length > 0) ? args[0] : "db.json";
        System.out.println("File name is " + fileName);

        if (args.length == 0) {
            out.println("Create a new collection (0) or load from the default file \"db.json\" (1) ?");
            String str = scanner.nextLine();
            myCollection = str.equals("0") ? new MyCollection() : Converter.fromJson(fileName);

        } else {
            fileName = args[0];
        }

        assert myCollection != null;
        Hashtable<Integer, Flat> flats = myCollection.getCollection();

        Invoker invoker = new Invoker(scanner, out, myCollection, fileName);
        invoker.run();
    }

}
