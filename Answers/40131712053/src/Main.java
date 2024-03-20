import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner=new Scanner(System.in);
    private static final int SHIFT_VALUE = 3;
    private static String encodedFullName;
    private static String encodedPhoneNumber;
    private static String encodedInterests;
    private static String encodedUserID;


    public static void main(String[] args) {
        setInitialData();
        String input;
        while (true){
            System.out.println("1-set full name\n2-set phone number\n3-set user ID\n4-set interests\n5-view user information\n6-view encoded user information\n7-exit");
            input=scanner.nextLine();
            if (input.equals("1")){
                String fullName =fullName();
                encodedFullName=informationEncoder(fullName,SHIFT_VALUE);

            }else if (input.equals("2")){
                String phoneNumber=phoneNumber();
                encodedPhoneNumber=informationEncoder(phoneNumber,SHIFT_VALUE);

            }else if (input.equals("3")){
                String userID=userId();
                encodedUserID=informationEncoder(userID,SHIFT_VALUE);

            }else if (input.equals("4")){
                ArrayList<String> interests=getInterests();
                StringBuilder interest_String = new StringBuilder();
                for(int i = 1; i <= interests.size(); i++){
                    interest_String.append(i).append(". ");
                    interest_String.append(interests.get(i-1)).append("\n");
                }
                encodedInterests=informationEncoder(interest_String.toString(),SHIFT_VALUE);

            }else if (input.equals("5")){
                String decodedFullName=informationDecoder(encodedFullName,SHIFT_VALUE);
                String decodedPhoneNumber=informationDecoder(encodedPhoneNumber,SHIFT_VALUE);
                String decodedUserID=informationDecoder(encodedUserID,SHIFT_VALUE);
                String decodedInterests=informationDecoder(encodedInterests,SHIFT_VALUE);
                String userInformation=userFullInformation(decodedFullName,decodedPhoneNumber,decodedUserID,decodedInterests);
                System.out.println(userInformation);


            }else if (input.equals("6")){
                System.out.println("encoded full name: " + encodedFullName);
                System.out.println("encoded phone number: " + encodedPhoneNumber);
                System.out.println("encoded userID: " + encodedUserID);
                System.out.println("encoded interests:\n" + encodedInterests);

            }else if (input.equals("7")){
                System.out.println("Good luck!" );
                break;

            }else {
                System.out.println("Invalid input");
            }

        }

    }

    public static void setInitialData(){
        encodedFullName=informationEncoder("(not provided yet)",SHIFT_VALUE);
        encodedPhoneNumber=informationEncoder("(not provided yet)",SHIFT_VALUE);
        encodedUserID=informationEncoder("(not provided yet)",SHIFT_VALUE);
        encodedInterests=informationEncoder("(not provided yet)",SHIFT_VALUE);
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
        System.out.println("enter 0 while you are done");
        ArrayList<String> interests = new ArrayList<>();
        while (interests.size()<10){
            int interest_number=interests.size()+1;
            System.out.println("interest "+interest_number + ":");
            String interest=scanner.nextLine();
            if(interest.equals("")){
                continue;
            }else if(interest.equals("0")){
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

    public static String userFullInformation(String fullName,String phoneNumber,String userID,String interests) {
        StringBuilder fullInformation = new StringBuilder();
        fullInformation.append("Hello! My name is ").append(fullName).append(". My ID is ").append(userID).append(". Here are some of my interests:\n");
        fullInformation.append(interests);
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

    public static String informationDecoder(String encodedInformation, int shift) {
        StringBuilder decodedInformation = new StringBuilder();

        for (int i = 0; i < encodedInformation.length(); i++) {
            char currentChar = encodedInformation.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char decodedChar = (char) (((currentChar - 'A' - shift + 26) % 26) + 'A');
                decodedInformation.append(decodedChar);
            }
            else if (Character.isLowerCase(currentChar)) {
                char decodedChar = (char) (((currentChar - 'a' - shift + 26) % 26) + 'a');
                decodedInformation.append(decodedChar);
            }
            else {
                decodedInformation.append(currentChar);
            }
        }

        return decodedInformation.toString();
    }

}