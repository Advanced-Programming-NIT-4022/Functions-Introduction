import java.util.Base64;
import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        System.out.println("Which Code? \n1  2  3  4  5  6  7");
        Scanner enter = new Scanner(System.in);
        int num = enter.nextInt();
        enter.nextLine();
        switch (num) {
            case 1:
                System.out.print("First name: ");
                String firstName = enter.nextLine();
                System.out.print("Last name: ");
                String lastName = enter.nextLine();
                String fullName = FullName(firstName, lastName);
                System.out.println("Output: " + fullName);
                break;
            case 2:
                System.out.print("Phone: ");
                String phoneNumber = enter.nextLine();
                String formattedNumber = formatPhoneNumber(phoneNumber);
                System.out.print("Output: " + formattedNumber);
                break;
            case 3:
                System.out.print("ID: ");
                String id = enter.nextLine();
                String ou = userId(id);
                System.out.println("Output: " + ou);
                break;
            case 4:
                System.out.print("How many interests you have?(max = 10)");
                int n = enter.nextInt();
                System.out.println("Output: " + getInterests(n));
                break;
            case 5:

            case 6:

            case 7:

            default:
                System.out.println("Wrong number.");
                break;
        }
    }

    public static String FullName(String firstName, String lastName) {
        String normalFirstName = capitalize(firstName);
        String normalLastName = capitalize(lastName);
        if (normalLastName.isBlank()) {
            return normalFirstName;
        } else {
            return normalFirstName + " " + normalLastName;
        }
    }
    public static String formatPhoneNumber(String Phone) {
        if (Phone.length() == 10) {
            return "0" + Phone;
        } else {
            return "Wrong entry. Try again.";
        }
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    public static String userId(String id){
        if(id.length() > 4 && id.length() < 13){
            return id;
        }else{
            return "it's invalid ";
        }
    }
    public static String getInterests(int n) {
        Scanner en = new Scanner(System.in);
        String[] interest = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Input: ");
            interest[i] = en.nextLine();
        }
        StringBuilder output = new StringBuilder("Output: {");
        for (int i = 0; i < n; i++) {
            output.append("\"").append(interest[i]).append("\"");
            if (i < n - 1) {
                output.append(", ");
            }
        }
        output.append("}");
        return output.toString();
    }
    public static String userFullInformation(String fullName,String phoneNumber,String userID,String[] interests,int nn){
        String result =  "Hello! My name is "+fullName+", My ID is "+userID+", Here are some of my interest:\n";
        int i = 0;
        while (i < nn){
            interests[i]= capitalize(interests[i]);
            result += i+1 + "." + interests[i] + "\n";
            i++;
        }
        result+= "You can reach me via my phone number "+phoneNumber + ".";
        return result;
    }
}
