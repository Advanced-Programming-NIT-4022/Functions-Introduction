import java.util.Scanner;

public class functionsIntroduction {
  public static String fullName(String firstName , String lastName)
  {
   return capitalizeFirstLetter(firstName)+ " "+ capitalizeFirstLetter(lastName);
  }
  private static String capitalizeFirstLetter(String str)
  {
    return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
  }
  /********************************************************************************************************************************************************************************** */
  public static String phoneNumber(String phone) {
    if (phone.length() == 10 && phone.startsWith("9")) {
        return "0" + phone;
    } else {
        System.out.println("Wrong entry. Try again.");
        return phoneNumber(new Scanner(System.in).nextLine());
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your First Name: ");
    String firstName = input.nextLine();
    System.out.println("Enter your Last Name: ");
    String lastName = input.nextLine();
    String fullName = fullName(firstName, lastName);
    System.out.println("Enter your Phone Number: ");
    String phone = phoneNumber(input.nextLine());

  }
}
