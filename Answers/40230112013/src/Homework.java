import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //// Get name and surname from the user and modify its format
        System.out.print("Please enter your name and surname: ");
        String firstName = scanner.next();
        String LastName = scanner.next();
        System.out.println(fullName(firstName, LastName));
        // The first function ended
        scanner.close();
    }

    public static String fullName(String firstName, String lastName) {
        if (firstName != null && firstName.isEmpty() == false) {
            firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase();
        }
        if (lastName != null && lastName.isEmpty() == false) {
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase();
        }
        return (firstName) + " " + (lastName);
    }

}
