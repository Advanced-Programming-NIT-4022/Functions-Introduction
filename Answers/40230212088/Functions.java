import java.util.Base64;
import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        System.out.println("Which Code? \n1  2  3  4  5  6  7");
        Scanner enter = new Scanner(System.in);
        int num = enter.nextInt();
        enter.nextLine();
        switch (num) {
            case 1:
                System.out.print("First name: ");
                String firstName = enter.nextLine();
                System.out.print("Last name: ");
                String lastName = enter.nextLine();
                String fullName = FullName(firstName, lastName);
                System.out.println("Output: " + fullName);
                break;
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            default:
                System.out.println("Wrong number.");
                break;
        }
    }

    public static String FullName(String firstName, String lastName) {
        String normalFirstName = capitalize(firstName);
        String normalLastName = capitalize(lastName);
        if (normalLastName.isBlank()) {
            return normalFirstName;
        } else {
            return normalFirstName + " " + normalLastName;
        }
    }


    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
