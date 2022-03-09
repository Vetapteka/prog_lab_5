package commands;

import model.Flat;

import java.util.Hashtable;

public class ReplaceIfLowerCommand extends ReplaceIf {

    public ReplaceIfLowerCommand(Hashtable<Integer, Flat> flats) {
        super(flats);
    }

    @Override
    public String getName() {
        return "replace_if_lower";
    }

    @Override
    public String getDescription() {
        return "replace the value by key if the new value is less than the old one";
    }

    @Override
    boolean checkCompareResult(int compareResult) {
        return compareResult < 0;
    }
}


