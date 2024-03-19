package com.company;

import java.util.Scanner;

public class Main {

    static String fullNameStatic = "";

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

    public static void main(String[] args) {

        //first function
        System.out.println("Full name : " + fullName());

    }
}
