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
}