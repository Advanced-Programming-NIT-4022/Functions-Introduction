package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static String fullNameStatic = "";
    static String phoneNumberStatic = "";
    static String idStatic = "";
    static int lenStatic;
    static String[] finalInterestsStatic = new String[10];

    public static String fullName(){
        System.out.println("enter your name : ");
        Scanner input = new Scanner(System.in);
        String firstname = input.nextLine();
        System.out.println("enter your lastname : ");
        String lastname = input.nextLine();
        char[] firstNameChar = firstname.toCharArray();
        char[] lastNameChar = lastname.toCharArray();

        for (int i = 0 ; i < firstNameChar.length ; i++){
            if (firstNameChar[i] >= 'A' && firstNameChar[i] <= 'Z'){
                firstNameChar[i]= (char) (firstNameChar[i]+32);
            }

        }
        firstNameChar[0]= (char) (firstNameChar[0]-32);

        for (int i = 0 ; i < lastNameChar.length ; i++){
            if (lastNameChar[i] >= 'A' && lastNameChar[i] <= 'Z'){
                lastNameChar[i]= (char) (lastNameChar[i]+32);
            }

        }
        lastNameChar[0]= (char) (lastNameChar[0]-32);

        fullNameStatic = String.valueOf(firstNameChar) + " " + String.valueOf(lastNameChar);
        return fullNameStatic;

    }

    public static String phoneNumber(){

        boolean condition = true;

        while (condition){
            Scanner input = new Scanner(System.in);
            String phoneNumber = input.nextLine();
            char[] phoneNumberChar = phoneNumber.toCharArray();
            if (phoneNumberChar[0] == '9' && phoneNumberChar.length == 10){
                phoneNumberStatic = "0" + String.valueOf(phoneNumberChar);
                return "0" + String.valueOf(phoneNumberChar);
            } else
                System.out.println("Wrong entry. Try again.");
        }

        return null;
    }

    public static String userId(){

        Scanner input = new Scanner(System.in);
        while (true){
            String id = input.nextLine();
            char[] idChar = id.toCharArray();
            if ( idChar.length <= 13 && idChar.length >= 3){
                idStatic = String.valueOf(idChar);
                return String.valueOf(idChar);
            } else
                System.out.println("Wrong entry. Try again.");
        }

    }

    public static String[] getInterests(){

        String[] interests = new String[10];
        Scanner input = new Scanner(System.in);
        int len = 0;
        for (int i = 0 ; i < 10 ; i++){
            String interest = input.nextLine();
            if (Objects.equals(interest, "end")){
                break;
            }
            interests[i]=interest;
            len++;
        }
        lenStatic = len;
        String[] finalInterests = new String[len];
        for (int i = 0 ; i < len ; i++){
            finalInterests[i] = interests[i];
        }

        for (int i = 0 ; i < len ; i++){
            finalInterestsStatic[i] = finalInterests[i];

        }

        return finalInterests;
    }

    public static String userFullInformation(){
        String s1 = "Hello! My name is " + fullNameStatic + ".My ID is " + idStatic + ". Here are some of my interests:";
        String s2 = "";
        for (int i = 0 ; i < lenStatic ; i++){
            s2 = s2 + "\n";
            s2 = s2 + (i+1) + ". " + finalInterestsStatic[i]  ;
        }
        String s3 = "You can reach me via my phone number " + phoneNumberStatic;
        return s1 + s2 + "\n" + s3;
    }

    public static String informationEncoder (String userInfo, int shift) {
        char[] informationChar = userInfo.toCharArray();

        for (int i = 0; i < informationChar.length; i++){
            char currentChar = informationChar[i];

            if (Character.isLetter(currentChar)) {
                char shifting;
                if (Character.isLowerCase(currentChar)) {
                    shifting = 'a';
                } else { shifting = 'A';}

                informationChar[i] = (char) ((currentChar - shifting + shift)%26 + shifting);

            }
        }

        return String.valueOf(informationChar);
    }

    public static void informationDecoder(String userInfo, int shift) {
        char[] informationChar = userInfo.toCharArray();

        for (int i = 0; i < informationChar.length; i++) {
            char currentChar = informationChar[i];

            if (Character.isLetter(currentChar)) {
                char shifting;
                if (Character.isLowerCase(currentChar)) {
                    shifting = 'a';
                } else { shifting = 'A';}
                int decoded = currentChar - shift - shifting;
                if (decoded < 0) {
                    decoded+= 26;
                }
                informationChar[i] = (char) (decoded + shifting);
            }
        }

        System.out.println(String.valueOf(informationChar));
    }

    public static void main(String[] args) {

        //first function
        System.out.println("Full name : " + fullName());

        //second function
        System.out.println("enter your phone number : ");
        System.out.println("phone number : " + phoneNumber());

        //third function
        System.out.println("enter your ID : ");
        System.out.println("ID : " + userId());

        //fourth function
        System.out.println("enter your interests : ");
        System.out.println("the maximum number of interests is 10.");
        System.out.println("if you want to enter less than 10 interests, you have to enter \"end\" when you are finished.");
        System.out.println(Arrays.toString(getInterests()));

        //fifth function
        //System.out.println(userFullInformation());
        String userInfo = userFullInformation();

        //sixth and seventh function
        System.out.println("if you want to see the encoded version of your info please enter \"encode\" , if you don't want to enter \"info\".");
        Scanner input = new Scanner(System.in);
        String entry = input.nextLine();

        if (Objects.equals(entry, "encode")){
            System.out.println("enter the amount of shift : ");
            int shift = input.nextInt();
            System.out.println(informationEncoder(userInfo , shift));
            System.out.println("if you want to see the decoded version enter \"decode\" and if you don't want to, enter anything :)." );
            Scanner input2 = new Scanner(System.in);
            String entry2 = input2.nextLine();
            if (Objects.equals(entry2, "decode")){
                String userInfo2 = informationEncoder(userInfo , shift);
                informationDecoder(userInfo2, shift);
            }
        }
        if (Objects.equals(entry, "info")){
            System.out.println(userFullInformation());
        }

    }
}
