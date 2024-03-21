import java.util.Objects;
import java.util.Scanner;

public class Main {

    static String fullname(String firstname , String lastname)
    {
        String lowfirst = firstname.toLowerCase();
        String lowlast = lastname.toLowerCase();
        String first = lowfirst.substring(0, 1).toUpperCase() + lowfirst.substring(1);
        String last = lowlast.substring(0, 1).toUpperCase() + lowlast.substring(1);
        return (first + ' ' + last);
    }

    static String phonenumber(String number)
    {
        if(number.length()!=10){return "wrong";}
        char[] num = number.toCharArray();
        if(num[0]!= '9'){return "wrong";}
        if (number.matches("[0-9]+")==false){return "wrong";}
        String resualt = '0'+ number;
        return resualt;
    }

    static String userid(String id)
    {
        if(id.length()>13 || id.length()<4){return "wrong";}
        if (id.matches("[0-9]+")==false){return "wrong";}
        else{return id;}
    }

    static String[] intrest(){

        System.out.println("please enter your interst");
        Scanner scanner = new Scanner(System.in);
        String[] intrests = new String[10];
        int i;
        for( i=0 ; i<10 ; i++)
        {
            intrests[i] = scanner.nextLine();
            System.out.println("if you dont want to add more to your intrests, please enter NO otherwise press any key");
            String s1= scanner.nextLine();
            if(Objects.equals(s1, "NO")){break;}
        }
        if(i==10){System.out.println("You have reached the limit!");}
        return intrests;
    }
    
    static String full(String name, String shomar , String userid, String[] alaqe){
        String S= "Hello! My name is " + name + ". My ID is " + userid +". Here are some of my interests:";
        String M="\n";
        for(int j=0 ; j<= alaqe.length ; j++){
            if(alaqe[j]==null){break;}
            M= M + ( j+1 + "." + alaqe[j]+ "\n");
        }
        String N= "You can reach me via my phone number "+ 0+shomar +".";
        return S+M+N;
    }
    static String ceasar(String payam , int shift)
    {
        while(true){
            if(shift<27){break;}
            else{shift= shift-26;}
        }
        char[] horof= payam.toCharArray();
        for(int i=0 ; i< horof.length ; i++)
        {
            if( horof[i]>=65 && horof[i]<=90){
                if(horof[i] + shift> 90){ horof[i] = (char)(horof[i] + shift - 26);}
                else{horof[i] = (char)(horof[i] + shift);}
            }
            if( horof[i]>=97 && horof[i]<= 122){
                if(horof[i] + shift> 122 ){ horof[i] = (char)(horof[i] + shift - 26);}
                else{horof[i] = (char)(horof[i] + shift);}
            }
        }
        return String.valueOf(horof);
    }
    static String undoceasar(String payam , int shift)
    {
        while(true){
            if(shift<27){break;}
            else{shift= shift-26;}
        }
        char[] horof= payam.toCharArray();
        for(int i=0 ; i< horof.length ; i++)
        {
            if( horof[i]>=65 && horof[i]<=90){
                if(horof[i] - shift< 65){ horof[i] = (char)(horof[i] - shift + 26);}
                else{horof[i] = (char)(horof[i] - shift);}
            }
            if( horof[i]>=97 && horof[i]<= 122){
                if(horof[i] - shift< 97 ){ horof[i] = (char)(horof[i] - shift + 26);}
                else{horof[i] = (char)(horof[i] - shift);}
            }
        }
        return String.valueOf(horof);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your firstname");
        String first = scanner.nextLine();
        System.out.println("please enter your lastname");
        String last = scanner.nextLine();
        String esm = fullname(first , last);
        System.out.println("please enter your phonenumber");
        String number = scanner.nextLine();
        while(true)
        {
            if(phonenumber(number)=="wrong")
            {
                System.out.println("Wrong entry. Try again.");
                number = scanner.nextLine();
            }
            else{
                break;
            }
        }
        System.out.println("please enter your id");
        String id = scanner.nextLine();
        while(true) {
            if(userid(id)=="wrong"){
                System.out.println("Wrong entry. Try again.");
                id = scanner.nextLine();
            }
            else {
                System.out.println(userid(id));
                break;
            }
        }
        String[] alayeq = intrest();
        System.out.println("How do you want to see your informations?   1.normal   2.coded");
        int op =scanner.nextByte();
        if(op==1){ System.out.println( full( esm , number , id , alayeq));}
        if(op==2){
            System.out.println("please enter a number for your shift");
            int shift=scanner.nextByte();
            System.out.println( ceasar( full( esm , number , id , alayeq),shift));
            System.out.println("If you want to see the decode version please enter YES");
            String decode= scanner.next();
            String coded=ceasar( full( esm , number , id , alayeq) , shift);
            if(Objects.equals(decode, "YES")){System.out.println(undoceasar( coded,shift));}
        }

    }
}