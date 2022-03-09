package utils;


import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Reader {


    public static Number readNumber(Function<String, Number> parser, Scanner scanner, PrintStream out, String startStr, Number min, Number max) {
        Number res;
        String str;

        while (true) {
            out.print(startStr);

            try {
                res = readParsebleNumber(parser, scanner.nextLine());
            } catch (IllegalArgumentException e) {
                out.println("enter the number in the range " + min + ".." + max);
                continue;
            }

            if (res.floatValue() < min.floatValue() || res.floatValue() > max.floatValue()) {
                out.println("the value must be in the range " + min + ".." + max);
                continue;
            }
            break;
        }
        return res;
    }


    public static String readString(Scanner scanner, PrintStream out, String startStr) {
        String res;
        while (true) {
            out.print(startStr);
            try {
                res = readNotEmptyString(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                out.println("The string cannot be empty");
                continue;
            }
            break;
        }
        return res;
    }

    public static <T extends Enum<T>> T readEnum(Class<T> tClass, Scanner scanner, PrintStream out, boolean canBeNull) {
        T res = null;
        String str;
        do {
            out.print(tClass.getSimpleName() + " (" + Arrays.stream(tClass.getEnumConstants()).map(Object::toString).reduce((x, y) -> x + " | " + y).orElse("") + "): ");
            str = scanner.nextLine().toUpperCase();
            if (str.equals("") && canBeNull) {
                str = "NONE";
            }
            try {
                res = T.valueOf(tClass, str);
            } catch (IllegalArgumentException e) {
                out.println("invalid value");
            }
        } while (res == null);
        return res;
    }

    public static String readNotEmptyString(String str) throws IllegalArgumentException {
        if (!str.equals("")) {
            return str;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Number readParsebleNumber(Function<String, Number> parser, String str) throws IllegalArgumentException {
        Number res;
        try {
            res = parser.apply(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return res;
    }


}
