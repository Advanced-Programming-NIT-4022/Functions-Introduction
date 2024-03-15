import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //for calling fullName method
        String fname = scan.nextLine();
        String lname = scan.nextLine();
        System.out.println(fullName(fname , lname));
    }
    public static String fullName(String firstName , String lastName){
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        firstName = firstName.substring(0 , 1).toUpperCase() + firstName.substring(1);
        lastName = lastName.substring(0 , 1).toUpperCase() + lastName.substring(1);
        return firstName + " " + lastName ;
    }
}