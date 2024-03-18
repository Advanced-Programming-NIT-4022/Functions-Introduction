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
        /*
        //for calling userId method
        System.out.println(userId());
        */

        //for calling getInterests method
        String[] array = getInterests();
        //for showing
        System.out.print("{");
        for(int i=0;i<10;i++){
            if(array[i].equals("***")) break;
            System.out.print(" \""+ array[i] + "\",");
        }
        System.out.print("\b}");
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

    public static String[] getInterests(){
        Scanner scan = new Scanner(System.in);
        String[] A = new String[10];
        for(int i=0;i<10;i++)
            A[i] = "***";
        System.out.println("Enter \"End\" for finish!");
        String tmp = "";
        for(int i=0;i<10;i++){
            tmp = scan.nextLine();
            if(tmp.equals("End") || tmp.equals("end")) break;
            A[i] = tmp;
        }
        return A;
    }
}