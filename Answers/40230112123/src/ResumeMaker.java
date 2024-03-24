// Resume Maker : A simple program for make a resume
import java.security.SecureRandom;
import java.util.Scanner;

public class ResumeMaker
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the following information below: ");

        // input name
        System.out.print("your first name: ");
        String firstName = input.nextLine();

        System.out.print("your last name: ");
        String lastName = input.nextLine();

        // store the full name of person
        String name = fullName(firstName, lastName);
        System.out.println("your name saved.");

        // input phone number
        System.out.print("your phone number: ");
        String phone;
        while (true)
        {
            phone = input.nextLine();
            phone = phoneNumber(phone);
            if (phone.equals("false"))
                System.out.println("Wrong entry. Try again.");
            else
            {
                System.out.println("your phone saved.");
                break;
            }
        }

        // input user id
        System.out.print("your user ID: ");
        String id;
        while (true)
        {
            id = input.nextLine();
            if (userId(id))
            {
                System.out.println("your ID saved.");
                break;
            }
            else
                System.out.println("ID should be between 4 to 13 digits. Try again.");
        }

        // input interests
        String interest;
        System.out.print("your interests(comma separated list): ");
        interest = input.nextLine();
        String[] interests = getInterests(interest);

        // show menu
        menu(name, phone, id, interests);
    }

    public static void menu(String fullName, String phoneNumber, String userId,
                            String[] interests)
    {
        Scanner input = new Scanner(System.in);
        String code = "Hello! My name is " + fullName +
                ".I like " + interests[0] + ".";
        String decode = "";
        int shift = 0; // shift value

        while (true)
        {
            int choice;
            System.out.printf("%n1. full information%n2. encode information%n");
            System.out.printf("3. decode information%n4. exit%n");
            System.out.printf("%nPlease enter your choice(1-4): ");
            choice = input.nextInt();

            // select the choice
            switch (choice) {
                case 1:
                    userFullInformation(fullName, phoneNumber, userId, interests);
                    break;
                case 2:
                    System.out.print("Enter the number to shift encode information(0 : random number): ");
                    shift = input.nextInt();
                    if (shift == 0) {
                        SecureRandom randomNumber = new SecureRandom();
                        shift = 1 + randomNumber.nextInt(25);
                        System.out.printf("Shift number is %d%n", shift);
                    }
                    decode = informationEncoder(code, shift);
                    break;
                case 3:
                    if (decode.equals(""))
                        System.out.println("You should first code your information.");
                    else
                        informationDecoder(decode, shift);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("invalid number!");
            }
        }
    }

    public static String fullName(String firstName, String lastName)
    {
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();

        int firstChar = firstName.charAt(0) - 32;
        firstName = firstName.substring(1);
        firstName = ((char) firstChar) + firstName;

        firstChar = lastName.charAt(0) - 32;
        lastName = lastName.substring(1);
        lastName = ((char) firstChar) + lastName;

        return (firstName + " " + lastName);
    }

    public static String phoneNumber(String phone)
    {
        if (phone.length() == 10 && phone.charAt(0) == '9')
            return ("0" + phone);
        else
            return ("false");
    }

    public static boolean userId(String id)
    {
        if(4 <= id.length() && id.length() <= 13)
            return true;
        else
            return false;
    }

    public static String[] getInterests(String interests)
    {
        String[] interestArray = interests.split(",");
        return interestArray;
    }

    public static void userFullInformation(String fullName, String phoneNumber, String userId,
                                           String[] interests)
    {
        System.out.printf("Hello! My name is %s. My ID is %s. ", fullName, userId);
        System.out.printf("Here are some of my interests:%n");
        for (int i = 0; i < interests.length; i++)
            System.out.printf("%d. %s%n", i + 1, interests[i]);
        System.out.printf("%nYou can reach me via my phone number %s.%n", phoneNumber);
    }

    public static String informationEncoder(String information, int shift)
    {
        String encodeInformation = "";

        for (int i = 0; i < information.length(); i++)
        {
            char character = information.charAt(i);
            if ('A' <= character && character <= 'Z')
            {
                character += shift;
                if(character > 'Z')
                    character -= 26; // 26 letters of En alphabetic
            } else if ('a' <= character && character <= 'z')
            {
                character += shift;
                if(character > 'z')
                    character -= 26; // 26 letters in En alphabetic
            }
            encodeInformation = encodeInformation + character;
        }
        System.out.printf("%nCode information : %s%n", encodeInformation);
        return encodeInformation;
    }

    public static void informationDecoder(String information, int shift)
    {
        char[] decodeInformation = new char[information.length()];

        for (int i = 0; i < information.length(); i++)
        {
            char character = information.charAt(i);
            if ('A' <= character && character <= 'Z')
            {
                character -= shift;
                if(character < 'A')
                    character += 26; // 26 letters of En alphabetic
            } else if ('a' <= character && character <= 'z')
            {
                character -= shift;
                if(character < 'a')
                    character += 26; // 26 letters in En alphabetic
            }
            decodeInformation[i] = character;
        }

        System.out.printf("%nDecode information : ");
        for (char character : decodeInformation)
            System.out.print(character);
        System.out.println();
    }
}