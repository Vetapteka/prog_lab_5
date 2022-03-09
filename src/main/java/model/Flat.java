package model;

import utils.Reader;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class Flat implements Serializable, Comparable<Flat> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long area; //Значение поля должно быть больше 0
    private int numberOfRooms; //Максимальное значение поля: 10, Значение поля должно быть больше 0
    private Furnish furnish = null; //Поле может быть null
    private View view; //Поле не может быть null
    private Transport transport; //Поле может быть null
    private House house = null; //Поле может быть null

    public Flat() {
    }

    public Flat(Scanner scanner, Integer id, PrintStream out) {
        this.id = id;
        creationDate = ZonedDateTime.now();
        name = Reader.readString(scanner, out, "Name: ");
        coordinates = new Coordinates(scanner, out);
        area = (Long) Reader.readNumber(Long::parseLong, scanner, out, "Area: ", 0, Long.MAX_VALUE);
        numberOfRooms = Reader.readNumber(Integer::parseInt, scanner, out, "NumberOfRooms: ", 0, 10).intValue();
        furnish = Reader.readEnum(Furnish.class, scanner, out, true);
        view = Reader.readEnum(View.class, scanner, out, false);
        transport = Reader.readEnum(Transport.class, scanner, out, true);
        out.println("enter value Home? y/n");

        house = (scanner.nextLine().equals("y")) ? new House(scanner, out) : null;

    }


    public House getHouse() {
        return house;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Long getArea() {
        return area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public View getView() {
        return view;
    }

    public Transport getTransport() {
        return transport;
    }

    @Override
    public String toString() {
        String ret;
        if (house == null) {
            ret = "{" + " id='" + id + "'" + ", name='" + name + "'" + ", coordinates='" + coordinates + "'"
                    + ", creationDate='" + creationDate.toString() + "'" + ", area='" + area + "'" + ", numberOfRooms='"
                    + numberOfRooms + "'" + ", furnish='" + furnish + "'" + ", view='" + view + "'" + ", transport='"
                    + transport + "'" + ", house='null'" + "}";
        } else {
            ret = "{" + " id='" + id + "'" + ", name='" + name + "'" + ", coordinates='" + coordinates + "'"
                    + ", creationDate='" + creationDate.toString() + "'" + ", area='" + area + "'" + ", numberOfRooms='"
                    + numberOfRooms + "'" + ", furnish='" + furnish + "'" + ", view='" + view + "'" + ", transport='"
                    + transport + "'" + ", house='" + house.toString() + "'" + "}";
        }
        return ret;

    }

    @Override

    public int compareTo(Flat b) {
        int n = Integer.compare(name.length(), b.getName().length());
        int r = Integer.compare(numberOfRooms, b.getNumberOfRooms());
        int t = Integer.compare(b.getTransport().ordinal(), transport.ordinal());
        int f = Integer.compare(b.getFurnish().ordinal(), furnish.ordinal());
        int v = Integer.compare(b.getView().ordinal(), view.ordinal());

        return Integer.compare((n + r + t + f + v), 3);
    }
}

