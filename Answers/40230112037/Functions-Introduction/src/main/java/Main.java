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

    public static String phoneNumber(String phone) {
        switch (phone.length()) {
            case 10:
                if (phone.charAt(0) != '9') {
                    throw new Error("invalid phone number! (enter phone number like 09xxxxxxxxx or 9xxxxxxxxx)");
                }
                phone = "0" + phone;
                break;
            case 11:
                if (phone.charAt(0) != '0' || phone.charAt(1) != '9') {
                    throw new Error("invalid phone number! (enter phone number like 09xxxxxxxxx or 9xxxxxxxxx)");
                }
                break;
            default:
                throw new Error("invalid phone number! (phone number length should be 10 or 11)");
        }
        for (char i : phone.toCharArray()) {
            if (i < '0' || i > '9') {
                throw new Error("invalid phone number! (phone number should only contains numbers)");
            }
        }
        return phone;
    }
}
