import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static String normalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
