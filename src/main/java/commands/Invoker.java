package commands;

import model.*;

import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Invoker {


    private final Hashtable<Integer, Flat> flats;
    private final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
    private final MyCollection myCollection;
    private final Date getInitialization_date;
    private final PrintStream out;
    private final Scanner scanner;
    private final String filename;

    private ExecuteCommand execute;


    public Invoker(Scanner scanner, PrintStream out, MyCollection myCollection, String fileName) {

        this.scanner = scanner;
        this.out = out;
        this.myCollection = myCollection;
        this.flats = myCollection.getCollection();
        this.getInitialization_date = myCollection.getInitialization_date();
        this.filename = fileName;
    }

    private LinkedHashMap<String, Command> initCommands() {

        HelpCommand help = new HelpCommand(commands);
        InfoCommand info = new InfoCommand(flats, getInitialization_date);
        ExitCommand exit = new ExitCommand();
        InsertCommand insert = new InsertCommand(flats);
        RemoveCommand remove = new RemoveCommand(flats);
        ClearCommand clear = new ClearCommand(flats);
        UpdateCommand update = new UpdateCommand(flats);
        CountByHouseCommand countByHouseCommand = new CountByHouseCommand(flats);
        ShowCommand show = new ShowCommand(flats);
        PrintFiledCommand printFiled = new PrintFiledCommand(flats);
        SaveCommand save = new SaveCommand(myCollection, filename);
        RemoveGreaterKeyCommand removeGreaterKeyCommand = new RemoveGreaterKeyCommand(flats);
        ReplaceIfGraterCommand replaceIfGrater = new ReplaceIfGraterCommand(flats);
        ReplaceIfLowerCommand replaceIfLower = new ReplaceIfLowerCommand(flats);
        FilterStartNameCommand filterStartName = new FilterStartNameCommand(flats);


        commands.put(help.getName(), help);
        commands.put(info.getName(), info);
        commands.put(exit.getName(), exit);
        commands.put(insert.getName(), insert);
        commands.put(remove.getName(), remove);
        commands.put(clear.getName(), clear);
        commands.put(update.getName(), update);
        commands.put(countByHouseCommand.getName(), countByHouseCommand);
        commands.put(show.getName(), show);
        commands.put(printFiled.getName(), printFiled);
        commands.put(save.getName(), save);
        commands.put(removeGreaterKeyCommand.getName(), removeGreaterKeyCommand);
        commands.put(replaceIfGrater.getName(), replaceIfGrater);
        commands.put(replaceIfLower.getName(), replaceIfLower);
        commands.put(filterStartName.getName(), filterStartName);

        return commands;
    }

    public void run() {

        ExecuteCommand executeCommand = new ExecuteCommand(this.initCommands());
        commands.put(executeCommand.getName(), executeCommand);
        executeCommand.run(scanner, out);

    }

}
