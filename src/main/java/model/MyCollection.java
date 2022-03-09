package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

public class MyCollection  implements Serializable {
    private final Date initialization_date;
    private final Hashtable<Integer, Flat> collection;

    public MyCollection() {
        initialization_date = new Date();
        collection = new Hashtable<>();
    }

    public Hashtable<Integer, Flat> getCollection() {
        return collection;
    }

    public Date getInitialization_date() {
        return initialization_date;
    }
}
