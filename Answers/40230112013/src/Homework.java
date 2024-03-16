import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //// Get name and surname from the user and modify its format
        System.out.print("Please enter your name and surname: ");
        String firstName = scanner.next();
        String LastName = scanner.next();
        fullName(firstName, LastName);
        // The first function finished and the second function(Phone number) started
        boolean again = true;
        while (again == true) {
            System.out.print("Please enter your phone number : ");
            String phonenum = scanner.next();
            phonenum = phoneNumber(phonenum);
            if (phonenum == "F")
                continue;
            else {
                System.out.println(phonenum);
                again = false;
                break;
            }
        }
        // The second function also done
        scanner.close();
    }

    /// fullname function :
    
    public static void fullName(String firstName, String lastName) {
        if (firstName != null && firstName.isEmpty() == false) {
            firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase();
        }
        if (lastName != null && lastName.isEmpty() == false) {
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase();
        }
        System.out.println((firstName) + " " + (lastName));
    }

    /// phone number function:

    public static String phoneNumber(String phone) {
        if (phone.startsWith("9") && phone.length() == 10) {
            return "0" + phone;
        } else {
            System.out.println("Invalid phone number. Please try again.");
            return "F";
        }
    }

}
