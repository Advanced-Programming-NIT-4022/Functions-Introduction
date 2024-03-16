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
        while (again) {
            System.out.print("Please enter your phone number : ");
            String phonenum = scanner.next();
            phonenum = phoneNumber(phonenum);
            if (phonenum == "F")
                continue;
            else {
                System.out.println("your phone number :" + phonenum);
                again = false;
                break;
            }
        }

        // The second function also done
        again = true;
        while (again) {
            System.out.print("Please enter your user ID : ");
            String UserIdentifier = scanner.next();
            UserIdentifier = userid(UserIdentifier);
            if (UserIdentifier.startsWith("I"))
                continue;
            else {
                System.out.println("Your user ID:" + UserIdentifier);
                break;
            }
        }
        // the third function is done
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
        System.out.println("The correct format of your name and surname:" + (firstName) + " " + (lastName));
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

    /// userId function:
    public static String userid(String Uid) {
        if (Uid.length() > 3 && Uid.length() < 15)
            return Uid;
        else
            return "Invalid value";

    }

}
