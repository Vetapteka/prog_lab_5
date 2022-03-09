package model;

import java.util.Comparator;

public class FurnishComparator implements Comparator<Furnish> {
    @Override

    public int compare(final Furnish a, final Furnish b) {
        return Integer.compare(a.ordinal(), b.ordinal());
    }

}
