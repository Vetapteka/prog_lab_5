package model;

import utils.Reader;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

public class Coordinates implements Serializable {
    private long x; //Максимальное значение поля: 285
    private Float y; //Максимальное значение поля: 76, Поле не может быть null

    public Coordinates(Scanner scanner, PrintStream out) {
        x = Reader.readNumber(Long::parseLong, scanner, out,
                "Coordinates x: ", Long.MIN_VALUE, 285).longValue();

        y = (Float) Reader.readNumber(Float::parseFloat, scanner, out,
                "Coordinates y: ", Float.MIN_VALUE, 76);
    }

    public Coordinates() {
    }

    public long getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + " x='" + x + "'" + ", y='" + y + "'" + "}";
    }
}