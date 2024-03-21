import java.util.Scanner;
import java.util.Objects;
import javax.management.BadStringOperationException;

public class Main{
    static boolean F = true;
    public static String fullName(String firstName, String lastName){
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        String[] name1 = firstName.split("");
        String[] last1 = lastName.split("");
        name1[0] = name1[0].toUpperCase();
        last1[0] = last1[0].toUpperCase();
        String res = "" ;
        for(int i =0 ; i< name1.length ;i++)
            res += name1[i];
        res += " ";
        for(int i =0 ; i< last1.length ;i++) {
            res += last1[i];
        }
        return res.trim() ;
    }
    public static String phoneNumber(long  phone){
        int count;
        long n = phone;
        for(count=0 ; n /10 != 0; count++)
        {
            n = n/10 ;
        }
        count ++;
        if (count != 10){
            F = true;
            return "f" ;
        }
        int size;
        String phone1 = String.valueOf(phone);
        String[] phone2 = phone1.split("");
        size = phone2.length;
        if (phone2[0] != "9") {
            String[] res = new String[size+1];
            res[0]="0";
            for (int i=0 ; i<phone2.length ;i++){
                res[i+1] = phone2[i];
            }
            String result="";
            for(int i =0 ; i< res.length ;i++) {
                result += res[i];
            }
            F = false;
            return result;
        }
        else{
            F = true;
            return "f" ;
        }
    }
    public static String userId( long id){
        int count;
        long n = id;
        for(count=0 ;n/10 != 0; count++)
        {
            n = n/10 ;
        }
        count++ ;
        if (count < 4 || count >13){
            F = true;
            return "f" ;
        }
        String id1 = String.valueOf(id);
        F = false;
        return id1;
    }
    public static String getInterests(){
        Scanner scan = new Scanner(System.in);
        String[] interests = new String[11];
        boolean flag = true;
        int i =0 ;
        System.out.println("If you want it to end, write \"finish\"");
        while (flag && i<10){
            System.out.println("enter your interest: ");
            interests[i] =scan.nextLine();
            if (Objects.equals(interests[i], "finish")){
                flag =false;
                continue;
            }
            i++;
        }
        String res="";
        for (int j = 0; !Objects.equals(interests[j], "finish") && (j < 10); j++){
            res = res + ((j+1) + ". " + interests[j]+"\n");
        }
        return res;
    }
    public static String userFullInformation(String fullName, String phoneNumber,String userID, String interests){
        String res = "Hello! My name is "+fullName+"."+" My ID is "+userID+"."+" Here are some of my interests:"+"\n"+interests + "\n"+"You can reach me via my phone number "+phoneNumber;
//        System.out.println("Hello! My name is "
//                +fullName+"."+" My ID is "+userID+"."+" Here are some of my interests:");
//        System.out.println(interests);
//        System.out.println("You can reach me via my phone number "+phoneNumber);
        return res;
    }

    public static void informationDecoder(String information, int shift){
        char[] information1 = information.toCharArray();
        char[] information2 = new char[information1.length];
        int n;
        for (int i=0 ; i< information1.length;i++){
            n = information1[i] - shift;
            if ((information1[i] >=65 && information1[i] <=90 ) && n<65){
                information2[i] = (char) (91+n-65);
            }
            else if ((information1[i] >96 && information1[i] <123) && n <= 96){
                information2[i] = (char) (122 +(n-96)) ;
            }
            else if ((information1[i] >96 && information1[i] <123) && ((n > 96 && n < 123))){  // tik
                information2[i] = (char) n;

            }
            else if ((information1[i] >=65 && information1[i] <=90 ) && ((n>=65 && n <=90))) {
                information2[i] = (char) n ;
            }
            else {
                information2[i]  = information1[i];
            }
        }
        for (int i=0 ; i < information2.length;i++){
            System.out.print(information2[i]);
        }
    }

    public static String informationEncoder( String information,int shift){
        char[] information1 = information.toCharArray();
        char[] information2 = new char[information1.length];
        int n;
        for (int i=0 ; i < information1.length ; i++){
            n = information1[i] + shift;
            if ((information1[i] >=65 && information1[i] <=90 ) && n > 90 ){
                information2[i] = (char) (64 + (n-90));
            }
            else if((information1[i] >96 && information1[i] <123) && n >122){
                information2[i] = (char) (96+(n-122));
            }
            else if ((information1[i] >=65 && information1[i] <=90 ) && (n>=65 && n<=90)){
                information2[i] = (char) n ;
            }
            else if ((information1[i] >96 && information1[i] <123) && (n>96 && n<123)){
                information2[i] = (char) n ;
            }
            else{
                information2[i]  = information1[i];
            }
        }
        String res="";
        for (int i=0 ; i < information2.length;i++){
            res += information2[i];
            System.out.print(information2[i]);
        }
        return res;
    }
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("First name: ");
        String firstName = scan.nextLine();
        System.out.print("Last name: ");
        String lastName = scan.nextLine();
        String fullName = fullName(firstName , lastName);
        String phoneNumber = new String();
        String ID = new String();
        while (F) {
            System.out.print("Phone number (do not insert first zero) : 0");
            long phone = scan.nextLong();
            phoneNumber = phoneNumber(phone);
        }
        F =  true;
        while (F) {
            System.out.print("User ID: ");
            long id = scan.nextLong();
            ID = userId(id);
        }
        F = true;
        String interests = getInterests();
        String result = userFullInformation(fullName,phoneNumber,ID,interests);
        System.out.println(result);
        while (F){
            int shift;
            System.out.println("do you want to coding information? (y/n)");
            String c = scan.next();
            if (Objects.equals(c, "y")){
                System.out.print("how many step you want to shift: ");
                shift = scan.nextInt();
                result=informationEncoder(result,shift);
                System.out.println("\n");
            }
            else{
                break;
            }
            System.out.println("do you want to decoding information? (y/n)");
            c = scan.next();
            if (Objects.equals(c, "y")){
                informationDecoder(result,shift);
            }
            else {
                break;
            }
        }
    }
}