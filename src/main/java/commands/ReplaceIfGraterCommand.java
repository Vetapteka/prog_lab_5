package commands;

import model.Flat;

import java.util.Hashtable;

public class ReplaceIfGraterCommand extends ReplaceIf{
    public ReplaceIfGraterCommand(Hashtable<Integer, Flat> flats) {
        super(flats);
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "replace value by key if new value is greater than old";
    }

    @Override
    boolean checkCompareResult(int compareResult) {
        return compareResult > 0;
    }
}
