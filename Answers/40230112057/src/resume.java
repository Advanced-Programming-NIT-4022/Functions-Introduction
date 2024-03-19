import java.util.Scanner;

public class resume {
    public static void  main(String[] args){

    }
    public String fullName(String firstName,String lastName){
        String First=firstName.toLowerCase();
        String Second=lastName.toLowerCase();
        char[] neww1=First.toCharArray();
        char[] neww2=Second.toCharArray();
        neww1[0]-=32;
        neww2[0]-=32;
        String akhari=new String(neww1);
        String akharii=new String(neww2);
        return akhari+" "+akharii;
    }
    public static String phoneNumber(String phone){
        Scanner input=new Scanner(System.in);
        while(phone.length()!=10 || phone.charAt(0)!='9'){
            System.out.println("Wrong entry. Try again.");
            phone=input.next();
        }
        return "0"+phone;
    }
    public static String userId(String id){
        Scanner input=new Scanner(System.in);
        while(4>=id.length() || 13<=id.length()){
            System.out.println("Wrong entry. Try again.");
            id=input.next();
        }
        return id;
    }


}
