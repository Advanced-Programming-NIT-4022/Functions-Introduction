import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstname = sc.nextLine();
        String lastname = sc.nextLine();
        //avalin commit
    }
    public static String fullName(String firstName, String lastName){

        String fs = firstName.toLowerCase();
        String ls = lastName.toLowerCase();
        String fc = fs.substring(0,1).toUpperCase() + fs.substring(1);
        String lc = ls.substring(0,1).toUpperCase() + ls.substring(1);
        String output = fc + " " + lc;
        return output;
    }
    //avalin commit

}
