import java.util.Scanner;
import java.util.ArrayList;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        informationDecoder(userFullinformation());

    }

    public static String fullName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = sc.nextLine();

        String fs = firstName.toLowerCase();
        String ls = lastName.toLowerCase();
        String fc = fs.substring(0,1).toUpperCase() + fs.substring(1);
        String lc = ls.substring(0,1).toUpperCase() + ls.substring(1);
        String output = fc + " " + lc;
        return output;
    }
    //avalin commit
    public static String phonenumber(){
        Scanner sc = new Scanner(System.in);
        String phone;
        while (true) {
            System.out.println("Please enter your phone number: ");
            phone = sc.nextLine();
            if (phone.length() > 10  ||  !phone.startsWith("9")) {
                System.out.println("Wrong entry. Try again.");
                continue;
            }
            break;
        }
            String output = "0" + phone;
        return output;
    }
    //commit 2
    public static String userid(){
        Scanner sc = new Scanner(System.in);
        String id ;
        while (true) {
            System.out.println("Please enter your id: ");
            id = sc.nextLine();
            char[] characters = id.toCharArray();
            boolean format = false;
            for (int i=0; i<characters.length; i++){
                if ( (int)characters[i] < 48 || (int)characters[i] > 57 ){
                    format = true;
                    break;
                }
            }
            if (id.length() < 4 || id.length() > 13 || format) {
                System.out.println("invalid format! please try again. ");
                continue;
            }
            break;
        }
        return id;
    }
    public static String getinterests(){
            Scanner sc = new Scanner(System.in);
            ArrayList<String> interests = new ArrayList<>();
            String input;
            System.out.println("Please enter your interests then enter 'esc':");

            while (interests.size() < 10) {
                input = sc.nextLine();
                if ("esc".equals(input)) {
                    break;
                }
                interests.add(input);
                // when 10 interests added method stops
                if (interests.size() == 10) {
                    System.out.println("Maximum of interests added!");
                    break;
                }
            }
            // in commit 6 im showing interests in another way
            // Create a formatted string of interests
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < interests.size(); i++) {
                output.append(i + 1).append(". ").append(interests.get(i));
                // Add a new line after each interest except the last one
                if (i != interests.size() - 1) {
                    output.append("\n");
                }
            }
            return output.toString();
        }
            // commit 4

    public static String userFullinformation() {
        String x = "Hello! My name is " + fullName() + ".";
        x += " My ID is " + userid() + ".";
        x += " Here are some of my interests:";
        String y = getinterests();
        String z = phonenumber();
        String fullInfo = x + "\n" + y + "\n\n" + "You can reach me via my phone number " + z + ".";
        return fullInfo;
    }

    // commit 5

   public static void informationDecoder(String sentence) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter amount of shift: ");
        int shift = sc.nextInt();
        char[] letter = sentence.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            if ((int) letter[i] > 64 && (int) letter[i] < 91) {
                letter[i] = (char) ((((int) letter[i] - 65 + shift) % 26) + 65);
            } else if ((int) letter[i] > 96 && (int) letter[i] < 123) {
                letter[i] = (char) ((((int) letter[i] - 97 + shift) % 26) + 97);
            }
            System.out.print(letter[i]);
        }
    }


}
