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

    public static String userFullInformation(String fullName,String phoneNumber,String userID,ArrayList<String> interests) {
        StringBuilder fullInformation = new StringBuilder();
        fullInformation.append("Hello! My name is ").append(fullName).append(". My ID is ").append(userID).append(". Here are some of my interests:\n");
        for(int i = 1; i <= interests.size(); i++){
            fullInformation.append(i).append(". ");
            fullInformation.append(interests.get(i-1)).append("\n");
        }
        fullInformation.append("\n");
        fullInformation.append("You can reach me via my phone number ").append(phoneNumber).append(".\n");
        return fullInformation.toString();
    }

    public static String informationEncoder(String information, int shift) {
        StringBuilder encodedInformation = new StringBuilder();

        for (int i = 0; i < information.length(); i++) {
            char currentChar = information.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char encodedChar = (char) (((currentChar - 'A' + shift) % 26) + 'A');
                encodedInformation.append(encodedChar);
            }
            else if (Character.isLowerCase(currentChar)) {
                char encodedChar = (char) (((currentChar - 'a' + shift) % 26) + 'a');
                encodedInformation.append(encodedChar);
            }
            else {
                encodedInformation.append(currentChar);
            }
        }

        return encodedInformation.toString();
    }


}