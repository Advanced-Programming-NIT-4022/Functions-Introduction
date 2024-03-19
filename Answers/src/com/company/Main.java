package com.company;

import java.util.Scanner;

public class Main {

    static String fullNameStatic = "";
    static String phoneNumberStatic = "";
    static String idStatic = "";

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

    public static void main(String[] args) {

        //first function
        System.out.println("Full name : " + fullName());

        //second function
        System.out.println("enter your phone number : ");
        System.out.println("phone number : " + phoneNumber());

        //third function
        System.out.println("enter your ID : ");
        System.out.println("ID : " + userId());

        



    }
}
