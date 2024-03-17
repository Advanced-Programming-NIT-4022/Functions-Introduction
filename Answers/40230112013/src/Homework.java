import java.util.*;

public class Homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //// Get name and surname from the user and modify its format
        System.out.print("Please enter your name and surname: ");
        String firstName = scanner.next();
        String LastName = scanner.next();
        firstName = fullName(firstName, LastName);
        // The first function finished and the second function(Phone number) started
        boolean again = true;
        String phonenum;
        do {
            System.out.print("Please enter your phone number : ");
            phonenum = scanner.next();
            System.out.print("\n");
            phonenum = phoneNumber(phonenum);
            if (phonenum == "F")
                continue;
            else {
                System.out.println("your phone number :" + phonenum + "\n");
                again = false;
            }
        } while (again);

        // The second function(phoneNumber) also done
        again = true;
        String UserIdentifier;
        do {
            System.out.print("Please enter your user ID : ");
            UserIdentifier = scanner.next();
            UserIdentifier = userid(UserIdentifier);
            if (UserIdentifier.startsWith("I"))
                continue;
            else {
                System.out.println("\nYour user ID:" + UserIdentifier + "\n");
                again = false;
                break;
            }
        } while (again);
        // the third function(userId) is done
        String[] interests = getInterests();
        int i = 0;
        System.out.println("your interest is : ");
        while (interests[i] != null) {
            int y = i + 1;
            String p = String.valueOf(y);
            System.out.println(p + "_" + interests[i]);
            i++;
        }
        // the fourth function(getInterests) is done

        String UFI = userFullInformation(firstName, phonenum, UserIdentifier, interests);

        // the fifth function(userFullInformation) is done
        again = true;
        String ask2;
        do {
            System.out.print("How to display the final information?\n1.Encrypted 2.simple 3.exit (end program)\n");
            ask2 = scanner.next();
            switch (ask2) {
                case "1":
                    System.out.print("Please enter the number of shifts: ");
                    int b = scanner.nextInt();
                    informationEncoder(b, UFI);
                    break;
                case "2":
                    System.out.println(UFI);
                    break;
                case "3":
                    again = false;
                    break;
                default:
                    System.out.println("invalid");
                    break;
            }
        } while (again);
        scanner.close();

        // The second series of programming exercises was done by the grace of God
    }

    /// fullname function :

    public static String fullName(String firstName, String lastName) {
        if (firstName != null && firstName.isEmpty() == false) {
            firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1).toLowerCase();
        }
        if (lastName != null && lastName.isEmpty() == false) {
            lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1).toLowerCase();
        }
        System.out.println("\nThe correct format of your name and surname: " + (firstName) + " " + (lastName) + "\n");
        return (firstName) + " " + (lastName);
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
        else {

            System.out.println("\nInvalid value , Please enter the correct ID ");
            return "I";
        }

    }

    /// getInterests function:
    public static String[] getInterests() {
        try (Scanner input = new Scanner(System.in)) {
            boolean again = true;
            String[] array = new String[9];
            int i = 0;
            String ask;
            while (again) {
                System.out.print("please enter you interest :");
                array[i] = input.next();
                System.out.print("\n");
                i++;
                System.out.println("Do you want to continue? \nyes or no ");
                ask = input.next();
                System.out.print("\n");
                switch (ask) {
                    case "yes":
                        break;
                    case "no":
                        again = false;
                        break;
                    default: {
                        System.out.println("\nThe value is invalid and receiving interests will end\n");
                        again = false;
                    }
                }
            }

            return array;
        }
    }

    /// userFullInformation function :

    public static String userFullInformation(String fullName, String phone1, String user1, String[] interests) {
        String p = "";
        p += ("\nHello! My name is " + fullName + ".");
        p += ("My ID is " + user1 + "." + "Here are some of my interests:\n");
        int i = 0;
        while (interests[i] != null) {
            int y = i + 1;
            String number = String.valueOf(y);
            p += (number + ". " + interests[i]);
            i++;
        }
        p += ("You can reach me via my phone number " + phone1 + ".");
        return p;
    }

    /// informationEncoder function :
    public static void informationEncoder(int shift, String text) {
        char[] character = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(character[i])) {
                char base = Character.isLowerCase(character[i]) ? 'a' : 'A';
                int offset = (character[i] - base + shift) % 26;
                character[i] = (char) (base + offset);
            }
        }
        String string = String.valueOf(character);
        System.out.println(string);
    }

    /// informationDecoder function:
    public static void informationDecoder(int shift, String text) {
        char[] character = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(character[i])) {
                char base = Character.isLowerCase(character[i]) ? 'a' : 'A';
                int offset = (character[i] - base - shift);
                if (offset >= 0)
                    offset %= 26;
                else
                    offset = 26 + offset;
                character[i] = (char) (base + offset);
            }
        }
        String string = String.valueOf(character);
        System.out.println(string);
    }

}
