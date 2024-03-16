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
    static String phoneNumber (String phone)
    {
        if(phone.startsWith("9") && phone.length()==10)
        {
            return "0"+phone;
        }
        if(phone.startsWith("0")&& phone.length()==10)
        {
            return phone;
        }
        if(!phone.startsWith("9")||phone.length()<10)
        {
            return "Wrong entry! Try again.";
        }
        return "Unknown error! Please check the input.";
    }

    public static void main(String[] args) {
        System.out.println("Please enter your name: ");
        Scanner input= new Scanner(System.in);
        String firstName= input.nextLine();
        System.out.println("Please enter your last name: ");
        Scanner inputL= new Scanner(System.in);
        String lastName= inputL.nextLine();
        //System.out.println(fullName(firstName,lastName));
        String returnedValue = phoneNumber("456743");
        do {

            System.out.println("Please enter your phone number: ");
            Scanner phNumberInput = new Scanner(System.in);
            String phNumber = phNumberInput.nextLine();
            System.out.println(phoneNumber(phNumber));
        }
        while (returnedValue.equals("Wrong entry! Try again."));

    }

}