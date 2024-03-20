import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {

    }

    public static String fullName(){
        String firstName="";
        String lastName="";
        System.out.println("first name:");
        while (firstName.equals("")){
            firstName=scanner.nextLine();
        }
        System.out.println("last name:");
        while (lastName.equals("")){
            lastName=scanner.nextLine();
        }

        return firstName + " " + lastName;
    }

    public static String phoneNumber(){
        System.out.println("Phone Number:");
        String phone="wrong";
        while (phone.equals("wrong")){
            phone=scanner.nextLine();
            boolean isAllDigits = true;
            for (int i = 0; i < phone.length(); i++) {
                if (!Character.isDigit(phone.charAt(i))) {
                    isAllDigits = false;
                    break;
                }
            }
            if (!isAllDigits) {
                System.out.println("please enter only digits");
                phone= "wrong";
            } else if(phone.length() !=10){
                System.out.println("please enter 10 digits");
                phone= "wrong";
            } else if(phone.charAt(0)!='9'){
                System.out.println("the first digit must be 9");
                phone= "wrong";
            }
        }
        return "0"+phone;
    }

    public static String userId(){
        String id="wrong";
        System.out.println("user ID:");
        while (id.equals("wrong")){
            id=scanner.nextLine();
            boolean isAllDigits = true;
            for (int i = 0; i < id.length(); i++) {
                if (!Character.isDigit(id.charAt(i))) {
                    isAllDigits = false;
                    break;
                }
            }
            if (!isAllDigits) {
                System.out.println("please enter only digits");
                id= "wrong";
            }
            if(id.length()<4 || id.length()>13){
                System.out.println("id length must be between 4 and 13");
                id= "wrong";
            }
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