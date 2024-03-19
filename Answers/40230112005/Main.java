import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String fullname(String first , String last) {//function to receive full name
        String firstname = first.toLowerCase();
        String lastname = last.toLowerCase();
        char[] f = firstname.toCharArray();
        char[] l = lastname.toCharArray();
        f[0] -= 32;
        l[0] -= 32;
        String ans = "";
        for (int i = 0; i < firstname.length(); i++) {
            ans += f[i];
        }
        ans += " ";
        for (int j = 0; j < last.length(); j++) {
            ans += l[j];
        }
        return ans;
    }

    public static String  num(){//function to receive number
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your Phone number: ");
        String number=sc.nextLine();
        char[] num= number.toCharArray();
        String ans="";
        if(number.length()==10 && num[0]=='9'){
            return "0"+number;
        }else if(number.length()==11 && num[0]=='0' && num[1]=='9'){
            return number;
        }else{
            System.out.println("Wrong entry. Try again.");
            return num();
        }
    }

    public static String ID(){//function to receive ID
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your ID: ");
        String studentid=sc.nextLine();
        if(studentid.length()<4  || studentid.length()>14){
            System.out.println("Wrong entry. Try again.");
            return ID();
        }else{
            return studentid;
        }
    }

    public static void intrest(){//function to receive interests
        String[] iintrest=getarray();
        System.out.print("{");
        for(int i=0;i<11;i++){
            if(!Objects.equals(iintrest[i], "0")) {
                System.out.print("\"" + iintrest[i] + "\""+",");
            }
            if(iintrest[i].equals("1")) {
                System.out.print("\b\b\b\b\b");
            }
        }
        System.out.print("}");
    }

    public static String[] getarray(){//function to get array from user/about function to receive interests
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Your Interests; At The End Enter 1.");
        String[] finalint=new String[11];
        for(int j=0;j<11;j++){
            finalint[j]="0";
        }
        for (int i=0;i<11;i++){
            finalint[i]=sc.nextLine();
            if(finalint[i].equals("1")){
                break;
            }
        }
        return finalint;
    }

    public static void info(){//function to show information
        Scanner scan=new Scanner(System.in);
        System.out.print("Full name: ");
        String full= scan.nextLine();
        String [] fname=full.split(" ",2 );
        String ffirst=fname[0];
        String flast=fname[1];
        String fulll=fullname(ffirst , flast);
        System.out.print("Phone number: ");
        String numm=num();
        System.out.print("User ID: ");
        String iidd=ID();
        System.out.print("Interests: ");
        String[] inter=getarray();
        System.out.print("Hello! My name is ");
        System.out.print(fulll);
        System.out.print(". My ID is ");
        System.out.print(iidd);
        System.out.println(". Here are some of my interests:");
        for(int i=0;i<11;i++){
            if(!Objects.equals(inter[i], "0") && !Objects.equals(inter[i], "1")) {
                System.out.println(i + 1 + ". " + inter[i]);
            }
        }
        System.out.print("\nYou can reach me via my phone number ");
        System.out.print(numm);
        System.out.println(".");
    }

    public static String coder(String codee,int shift){//function to decode
        char[] code=codee.toCharArray();
        for(int i=0;i<codee.length();i++){
            if(code[i]>96 && code[i]<123){
                int i1 = (((int) code[i] + (shift%26)-96) % 26)+96;
                code[i]= (char) i1;
            }else if(code[i]>64 && code[i]<91){
                int i2=(((int)code[i]+(shift%26)-64)%26)+64;
                code[i]= (char) i2;
            }

        }
        String finalcode="";
        for(int i=0;i<codee.length();i++){
            finalcode+=code[i];
        }
        return finalcode;
    }

    public static String readable(String code,int shift){//function to make code readable
        char[] codee=code.toCharArray();
        for(int i=0;i<code.length();i++){
            if(codee[i]>96 && codee[i]<123){
                int i1 = (((int) codee[i] + (26-(shift%26))-97) % 26)+97;
                codee[i]= (char) i1;
            }else if(codee[i]<91 && codee[i]>64){
                int i2 = (((int) codee[i] + (26-(shift%26))-65) % 26)+65;
                codee[i]= (char) i2;
            }
        }
        String finalcode="";
        for(int i=0;i<code.length();i++){
            finalcode+=codee[i];
        }
        return finalcode;
    }



    public static void main(String[] args){
        //function to receive full name
        /*Scanner sc= new Scanner(System.in);
        System.out.println("Enter Your First name: ");
        String first=sc.nextLine();
        System.out.println("Enter Your Last name: ");
        String last=sc.nextLine();
        System.out.println(fullname(first , last));*/

        //function to receive number
       /*ystem.out.println(num());*/

        //function to receive ID
       /* System.out.println(ID());*/

        //function to receive interests
       /* intrest();*/

        //function to show info
       /* info();*/

        //function to decode
       /* Scanner sc=new Scanner(System.in);
        String code=sc.nextLine();
        int shift=sc.nextInt();
        System.out.println(coder(code,shift));*/

        //function to make code readable
       /* Scanner sc=new Scanner(System.in);
        String code=sc.nextLine();
        int shift=sc.nextInt();
        System.out.println(readable(code , shift));*/
    }
}