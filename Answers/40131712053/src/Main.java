import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static String fullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }

    public static String phoneNumber(String phone){
        boolean isAllDigits = true;
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                isAllDigits = false;
                break;
            }
        }
        if (!isAllDigits) {
            return "wrong";
        }
        if(phone.length() !=10){
            return "wrong";
        }
        if(phone.charAt(0)!='9'){
            return "wrong";
        }
        return "0"+phone;
    }

    public static String userId(String id){
        boolean isAllDigits = true;
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                isAllDigits = false;
                break;
            }
        }
        if (!isAllDigits) {
            return "wrong";
        }
        if(id.length()<4 || id.length()>13){
            return "wrong";
        }
        return id;
    }

    public static ArrayList<String> getInterests(){
        System.out.println("enter exit while you are done");
        ArrayList<String> interests = new ArrayList<>();
        while (interests.size()<10){
            int interest_number=interests.size()+1;
            System.out.println("interest "+interest_number + ":");
            String interest=scanner.nextLine();
            if(interest.equals("")){
                continue;
            }else if(interest.equals("exit")){
                if(interests.size()==0){
                    System.out.println("you have to enter at least one interest");
                    continue;
                }else {
                    break;
                }

            }else {
                interests.add(interest);
            }

        }
        return interests;
    }





}