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
            System.out.print("\n");
            phonenum = phoneNumber(phonenum);
            if (phonenum == "F")
                continue;
            else {
                System.out.println("your phone number :" + phonenum +"\n");
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
                System.out.println("\nYour user ID:" + UserIdentifier + "\n");
                break;
            }
        }
        // the third function is done
        String[] interests = getInterests();
        int i=0;
        System.out.println("your interest is : ");
        while (interests[i]!=null) {
            int y=i+1;
            String p = String.valueOf(y);
            System.out.println(p + "_" + interests[i]);
            i++; 
        }
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
        System.out.println("\nThe correct format of your name and surname: " + (firstName) + " " + (lastName)+ "\n");
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
        else{
            
            System.out.println("\nInvalid value , Please enter the correct ID ");
            return "I";
        }

    }

    ///getInterests function:
    public static String[] getInterests() {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        String[] array = new String[9];
        int i = 0;
        String ask;
        while (again) {
            System.out.print("please enter you interest :");
            array[i] = scanner.next();
            System.out.print("\n");
            i++;
            System.out.println("Do you want to continue? \nyes or no ");
            ask = scanner.next();
            System.out.print("\n");
            switch (ask) {
                case "yes":  
                    break;
                case "no" :
                again=false;
                break;
                default:
                    {System.out.println("\nThe value is invalid and receiving interests will end\n");
                    again = false;}
            }
        }
        scanner.close();
        return array;
    }

}
