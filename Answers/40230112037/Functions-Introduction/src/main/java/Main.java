import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    public static String normalizeName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    public static String fullName(String firstName, String lastName) {
        if (firstName.isBlank()) {
            throw new Error("firstName is Empty!");
        }
        if (lastName.isBlank()) {
            throw new Error("lastName is Empty!");
        }
        firstName = normalizeName(firstName);
        lastName = normalizeName(lastName);
        return firstName + " " + lastName;
    }
}
