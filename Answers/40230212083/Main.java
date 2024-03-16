import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*
        //for calling fullName method
        String fname = scan.nextLine();
        String lname = scan.nextLine();
        System.out.println(fullName(fname , lname));
        */
        /*
        //for calling phoneNumber method
        System.out.println(phoneNumber());
        */

        //for calling userId method
        System.out.println(userId());
    }
    public static String fullName(String firstName , String lastName){
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        firstName = firstName.substring(0 , 1).toUpperCase() + firstName.substring(1);
        lastName = lastName.substring(0 , 1).toUpperCase() + lastName.substring(1);
        return firstName + " " + lastName ;
    }
    public static String phoneNumber(){
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        if(number.length() == 10 && number.charAt(0)=='9'){
            return '0' + number;
        }else if(number.length()==11 && number.charAt(0)=='0'){
            return number;
        }else{
            System.out.println("Wrong entry. Try again.");
            return phoneNumber();
        }
    }
    public static String userId(){
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        if(id.length()<4 || id.length()>13){
            return userId();
        }else{
            for(int i=0;i<id.length();i++){
                if(id.charAt(i)>47 && id.charAt(i)<58) continue; //check for char is number or not
                else return userId();
            }
            return id;
        }
    }
}