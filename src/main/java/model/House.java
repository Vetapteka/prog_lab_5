package model;

import utils.Reader;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

public class House implements Serializable{
    private String name; //Поле не может быть null
    private Long year; //Максимальное значение поля: 550, Значение поля должно быть больше 0
    private long numberOfFlatsOnFloor; //Значение поля должно быть больше 0

    public House() {
    }

    public House(Scanner scanner, PrintStream out) {
        name = Reader.readString(scanner, out, "House.name: ");
        year = (Long) Reader.readNumber(Long::parseLong, scanner, out, "House.year: ", 0, 551);
        numberOfFlatsOnFloor = Reader.readNumber(Long::parseLong, scanner, out,
                "House.numberOfFlatsOnFloor: ", 0, Long.MAX_VALUE).longValue();
    }

    public String getName() {
        return name;
    }

    public Long getYear() {
        return year;
    }

    public long getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", year='" + getYear() + "'" + ", numberOfFlatsOnFloor='"
                + getNumberOfFlatsOnFloor() + "'" + "}";
    }


    public boolean compare(House house) {

        return house.getName().equals(this.name) &&
                house.getYear().equals(this.year) && (house.getNumberOfFlatsOnFloor() == this.numberOfFlatsOnFloor);
    }

}
