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
  /*********************************************************************************************************************************************************************************** */
  public static String userId(String id)
  {
    if (id.length() <= 4 || id.length() >= 13)
    {
      return id;
    }
    else
    {
      System.out.println("userID should be between 4 to 13 digits. try again.");
      return userId(new Scanner(System.in).nextLine());
    }
  }
  /********************************************************************************************************************************************************************************** */
  public static String[] getInterests(int maxInterests) 
  {
        Scanner scanner = new Scanner(System.in);
        String[] interests = new String[maxInterests];
        int count = 0;
        System.out.println("Enter your interests (max 10):");
        while (count < maxInterests)
         {
            String interest = scanner.nextLine();
            if (interest.isEmpty()) 
            {
                break; // User finished entering interests
            }
            interests[count] = interest;
            count++;
        }
        return interests;
    }
    /********************************************************************************************************************************************************************************** */
    public static String userFullInformation(String fullName, String phone, String id, String[] interests)
    {
      StringBuilder full = new StringBuilder();
      full.append("Hello! My name is ").append(fullName).append(". My ID is ").append(id).append(". Here are some of my interests:\n");
      for(int i=0; i < interests.length && interests[i] != null; i++)
      {
        full.append(i+1).append(". ").append(interests[i]).append("\n");
      }
      full.append("You can reach me via my phone number ").append(phone).append("\n");
      return full.toString();
    }
    /********************************************************************************************************************************************************************************** */
    public static String informationEncoder(String information, int shift)
    {
      StringBuilder encode = new StringBuilder();
      for(int i = 0 ; i < information.length() ; i++)
      {
        char c = information.charAt(i);
        if(Character.isAlphabetic(c))
        {
          int newChar = c+shift;
          if(Character.isUpperCase(c))
          {
            encode.append((char)(newChar < 'A' ? newChar + 26 : newChar))
          }
          else
          {
            encode.append((char)(newChar < 'a' ? newChar + 26 : newChar));
          }
        }
        else {
          encode.append(c);
        }
      }
      return encode.toString();
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
    System.out.println("Enter your ID: ");
    String id = userId(scanner.nextLine());
    String[] interests = getInterests(10);
    String fullInformation = userFullInformation(fullName, phone, id, interests);
    System.out.println("Would you Like to see the encoded information? (y for yes/n for no)");
    String choice = input.nextLine().toLowerCase;
    if(choice.equals("y"))
    {
      System.out.print("How many units should the letters be shifted? (Enter a positive number): ");
      int Shift = Integer.parseInt(input.nextLine());
      String encodedIformation = informationEnceoder(fullIformation, shift);
      System.out.println(encodedInformation);
    }
  }
}
