//402 3171 2003
//یاس حسن پور
package org.example;

import java.util.Scanner;

public class Main {
   static String fullName(String name, String lastName)
    {
        String lowerCaseN= name.toLowerCase();
        String lowerCaseLN= lastName.toLowerCase();
        char[] firstNameCharArray =lowerCaseN.toCharArray();
        char[] lastNameCharArray= lowerCaseLN.toCharArray();
        if(firstNameCharArray.length > 0)
        {
            firstNameCharArray[0] = Character.toUpperCase(firstNameCharArray[0]);
        }
        if(lastNameCharArray.length > 0)
        {
            lastNameCharArray[0] = Character.toUpperCase(lastNameCharArray[0]);
        }
        return new String(firstNameCharArray) + " " + new String(lastNameCharArray);
    }

    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        Scanner input= new Scanner(System.in);
        String firstName= input.nextLine();
        System.out.println("Please enter your last name: ");
        Scanner inputL= new Scanner(System.in);
        String lastName= inputL.nextLine();
        System.out.println(fullName(firstName,lastName));
    }

}