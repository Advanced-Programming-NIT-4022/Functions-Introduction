import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main (String[] arqs){
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        System.out.println("please enter your first name");
        String x = input.next();
        String firstname =  fullName (x );
        System.out.println("please enter your last name");
        String y = input.next();
        String lastname = fullName (y);
        String fullName = firstname + " " + lastname;
        String phoneNumber ;
        System.out.println("enter your phoneNumber please ");
        while (true){
            String x1 =  input.next() ;
            phoneNumber = phoneNumber (x1);
            if (phoneNumber == "0") {
                System.out.println("Wrong entry. Try again.");
            }
            else{
                phoneNumber = "0" + phoneNumber;
                break;
            }
        }
        String id;
        System.out.println("enter your id plaese") ;
        while(true){
            Integer  x2 = input.nextInt();
            id = userId (x2 );
            if (id=="0"){
                System.out.println("Wrong entry. Try again.");
            }
            else{
                break;
            }
        }
        String interests = "";
        Integer  count=0;
        System.out.println("enter 1 of your interest please");
        while(count<10){
            String n = input.next();
            interests = interests + getInterests(n) ;
            System.out.println("You wanna add 1 more ? enter 1 or 0 . (1 means yes and 0 means no) ");
            Integer answer = input.nextInt() ;
            if(answer== 1){
                count ++ ;
            }
            else{
                break ;
            }
        }
        if(count == 10){
            count --;
        }
        userFullInformation(fullName , phoneNumber, id , interests , count);
        System.out.println("please enter an Encoder information ");
        String information1 = input1.nextLine() ;
        System.out.println("please enter a number");
        Integer shift = input2.nextInt() ;
        informationEncoder(information1, shift) ;
        System.out.println();
        System.out.println("please enter an Decoder information ");
        String information2 = input3.nextLine() ;
        System.out.println("please enter a number");
        Integer shift2 = input4.nextInt() ;
        informationDecoder(information2, shift2) ;
    }
    public static String fullName(String x){
        String xx = x.toLowerCase() ;
        String xxx = xx.substring(0 , 1 ). toUpperCase() + xx .substring(1) ;
        return xxx;
    }
    public static String phoneNumber (String x1 ){
        char ch[] = x1.toCharArray();
        if((x1.length() == 10) && (ch[0]=='9'))
            return x1 ;
        else{
            return "0";
        }
     }
    public static String userId(Integer x2){
        String xx2 = String.valueOf(x2);
        if((3<= xx2.length() ) && (xx2.length() <= 14) ){
            return xx2;
        }
        else{
            return "0";
        }
    }
    public static String  getInterests(String n){
        return n + " " ;
    }
    public static void  userFullInformation(String fullName, String phoneNumber ,String id , String interests , Integer count){
        System.out.println("Hello! My name is " + fullName + ". My ID is " + id + ". Here are some of my interests:" );
        String [] temp = interests.split(" ");
        Integer shomareh = 1 ;
        for (Integer i=0 ; i<=count ; i++){
            System.out.print(shomareh);
            System.out.print(". ");
            System.out.println(temp[i]);
            shomareh ++ ;
        }
        System.out.println();
        System.out.println("You can reach me via my phone number " + phoneNumber + ".");
    }
    public static void informationEncoder(String information1,Integer shift) {
        int asci = 0 ;
        Integer shift1;
        Integer one = 1 ;
        String [] temp1 = information1.split(" ");
         for (int i =0 ; i< temp1.length ; i++){
            Integer b = 1;
            for (int j =0 ; j< temp1[i].length(); j++){
                int adad = (int)temp1[i].charAt(j);
                if ((temp1[i].charAt(j)>'z')|| (temp1[i].charAt(j)<'A' )){
                    System.out.print(temp1[i].charAt(j));
                    break;
                } else if (true) {
                    for(int k=1 ; k<=shift ; k++){
                        b=1 ;
                        if((temp1[i].charAt(j)>='A') && ( temp1[i].charAt(j)<='Z')){
                            asci= adad + one;
                            if(asci >=  'Z') {
                                shift1= shift - k ;
                                adad = 64;
                                for(int l=1  ; l<=shift1 ; l++){
                                    asci = adad + one;
                                    adad = asci ;
                                }
                                System.out.print((char)asci);
                                b=0 ;
                                break;
                            }
                        }
                        else if((temp1[i].charAt(j)>='a') && ( temp1[i].charAt(j)<='z')){
                            asci= adad+ one;
                            if(asci >=  'z') {
                                shift1= shift - k ;
                                adad = 96;
                                for(int l=1  ; l<=shift1 ; l++){
                                    asci = adad + one;
                                    adad = asci ;

                                }
                                System.out.print((char)asci);
                                b=0 ;
                                break;
                            }
                        }
                        adad = asci;
                    }
                    if(b==1){
                        System.out.print((char)asci);
                    }
                }
            }
            System.out.print(" ");
        }
    }
    public static void informationDecoder(String information2, Integer shift2){
        int ascii = 0 ;
        Integer shift3;
        Integer one = 1 ;
        String [] temp1 = information2.split(" ");
        for (int i =0 ; i< temp1.length ; i++){
            Integer b = 1;
            for (int j =0 ; j< temp1[i].length(); j++){
                int adad = (int)temp1[i].charAt(j);
                if ((temp1[i].charAt(j)>'z')|| (temp1[i].charAt(j)<'A' )){
                    System.out.print(temp1[i].charAt(j));
                    break;
                } else if (true) {
                    for(int k=1 ; k<=shift2 ; k++){
                        b=1 ;
                        if((temp1[i].charAt(j)>='A') && ( temp1[i].charAt(j)<='Z')){
                            ascii= adad - one;
                            if(ascii <=  'A') {
                                shift3= shift2 - k ;
                                adad = 91;
                                for(int l=1  ; l<=shift3 ; l++){
                                    ascii = adad - one;
                                    adad = ascii ;
                                }
                                System.out.print((char)ascii);
                                b=0 ;
                                break;
                            }
                        }
                        else if((temp1[i].charAt(j)>='a') && ( temp1[i].charAt(j)<='z')){
                            ascii= adad - one;
                            if(ascii <=  'a') {
                                shift3= shift2 - k ;
                                adad = 123;
                                for(int l=1  ; l<=shift3 ; l++){
                                    ascii = adad - one;
                                    adad = ascii ;

                                }
                                System.out.print((char)ascii);
                                b=0 ;
                                break;
                            }
                        }
                        adad = ascii;
                    }
                    if(b==1){
                        System.out.print((char)ascii);
                    }
                }
            }
            System.out.print(" ");
        }
    }
}
