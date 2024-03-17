import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fullName());
        phonenumber();
        userid();
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
    public static void phonenumber(){
        Scanner sc = new Scanner(System.in);
        long phone;
        while (true) {
            System.out.println("Please enter your phone number: ");
            phone = sc.nextLong();
            if (phone / 1000000000 != 9) {
                System.out.println("Wrong entry. Try again.");
                continue;
            }
            break;
        }
            long[] arr = new long[11];
            arr[0] = 0;
            for (int i=10; i>0; i--){
                arr[i] = phone%10;
                phone /= 10;
            }
            for (int i=0; i<11; i++){
                System.out.print(arr[i]);
            }
            System.out.println();
    }
    //commit 2
    public static void userid(){
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
        System.out.println(id);
    }
}
