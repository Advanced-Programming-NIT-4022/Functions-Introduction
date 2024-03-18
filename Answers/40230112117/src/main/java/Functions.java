import java.util.Scanner;
import java.util.ArrayList;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        userFullinformation();

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
        System.out.println("Please enter your interests then enter esc :");

                while (interests.size() < 10) {
                    input = sc.nextLine();
                    if ("esc".equals(input)) {
                        break;
                    }
                    interests.add(input);
                    // when 10 interests added method stops
                    if (interests.size() == 10) {
                        System.out.println("maximum of interests added ! ");
                        break;
                    }
                }

                // convert arraylist to array of strings
                String[] interestsArray = interests.toArray(new String[0]);

                String output = "";
                output += "{";
                for (int i=0; i<interestsArray.length; i++) {
                    output += "\"";
                    output += interestsArray[i];
                    output += "\"";
                    if (i != interestsArray.length-1)
                        output += "," + " ";
                }
                output += "}";
                return output;
            }
            // commit 4

    public static void userFullinformation(){
        String x ="Hello! My name is " + fullName() + ".";
        x +=" My ID is " + userid() + ".";
        x +=" Here are some of my interests:";
        String y = getinterests();
        String z = phonenumber();
        System.out.println(x);
        System.out.println(y);
        System.out.println();
        System.out.print("You can reach me via my phone number " + z + "." );
    }
    // commit 5

}
