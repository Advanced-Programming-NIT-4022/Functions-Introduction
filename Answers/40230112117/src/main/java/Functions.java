import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //get first name and last name
        System.out.println("Please enter your first name: ");
        String firstname = sc.nextLine();
        System.out.println("Please enter your last name: ");
        String lastname = sc.nextLine();
        //avalin commit

        //get phone number
        long phone;
        while (true){
            System.out.println("Please enter your phone number: ");
            phone = sc.nextLong();
            if (phone/1000000000 != 9){
                System.out.println("Wrong entry. Try again.");
                continue;
            }
            break;
        }
            //commit 2

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
    public static void phonenumber(long num){
            long[] arr = new long[11];
            arr[0] = 0;
            for (int i=10; i>0; i--){
                arr[i] = num%10;
                num /= 10;
            }
            for (int i=0; i<11; i++){
                System.out.print(arr[i]);
            }
    }
    //commit 2
}
