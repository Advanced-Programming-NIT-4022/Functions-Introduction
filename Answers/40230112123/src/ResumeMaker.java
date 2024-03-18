// Resume Maker : A simple program for make a resume
import java.security.SecureRandom;

public class ResumeMaker
{
    public static void main(String[] args)
    {

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

    public static String[] getInterests(String... interests)
    {
        String[] interestArray = new String[interests.length];
        for (int i = 0; i < interests.length; i++)
            interestArray[i] = interests[i];
        return interestArray;
    }

    public static void userFullInformation(String fullName, String phoneNumber, String userId,
                                           String[] interests)
    {
        System.out.printf("Hello! My name is %s . My ID is %s. ", fullName, userId);
        System.out.printf("Here are some of my interests:%n");
        for (int i = 0; i < interests.length; i++)
            System.out.printf("%d. %s%n", i, interests[i]);
        System.out.printf("%nYou can reach me via my phone number %s.", phoneNumber);
    }
}