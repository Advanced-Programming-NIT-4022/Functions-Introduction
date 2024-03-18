//402 3171 2003
//یاس حسن پور
package org.example;

import java.util.Arrays;
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
        if(phone.startsWith("0")&& phone.length()==11)
        {
            return phone;
        }
        if(!phone.startsWith("9")||phone.length()<10||phone.length()>11)
        {
            return "Wrong entry! Try again.";
        }
        return "Unknown error! Please check the input.";
    }
    static String userID(String id)
    {
        if(id.length()>=4 && id.length()<=13)
        {
            return id;
        }
        else
        {
            return "Invalid user ID. Try again.";
        }

    }
    static String[] getInterests(String[] userInterests)
    {

        for(int i=0; i<userInterests.length; i++) {
            if (userInterests[i].equalsIgnoreCase("done")) {
                return Arrays.copyOf(userInterests, i);
            }
        }
        return userInterests;
    }
    static void userFullInformation(String fullName, String phoneNumber, String userID, String[] interests)
    {
        System.out.println("Hello, my name is "+fullName+". "+"My ID is "+userID+". "+"Here are some of my interests:");
        for(int i =0; i< interests.length; i++)
        {
            System.out.println((i+1)+". "+interests[i]);
        }
        System.out.println("\nYou can reach me via my phone number"+ phoneNumber+".");


    }

    public static void main(String[] args) {
        System.out.print("Please enter your name: ");
        Scanner input= new Scanner(System.in);
        String firstName= input.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName= input.nextLine();
        String finalFullName = fullName(firstName,lastName);
        System.out.println(finalFullName);

        String returnedValuePhoneN;
        String finalNumber;
        do {
            System.out.print("\nPlease enter your phone number: ");
            String phNumber = input.nextLine();
            returnedValuePhoneN = phoneNumber(phNumber);
            finalNumber=phoneNumber(returnedValuePhoneN);
            System.out.println(finalNumber);
        }
        while (returnedValuePhoneN.equals("Wrong entry! Try again."));

        String returnedValueID;
        do {
            System.out.print("\nPlease enter your user ID: ");
            String idNum = input.nextLine();
            returnedValueID = userID(idNum);
            System.out.println(returnedValueID);
        }
        while (returnedValueID.equals("Invalid user ID. Try again."));

        System.out.print("\nWhat are your interests? If done, type \"Done\" : ");
        String[] interests = new String [10];

        for(int i=0; i<10; i++)
        {
            interests [i] = input.nextLine();
            if (interests[i].equalsIgnoreCase("done"))
            {
                break;
            }
        }
        System.out.println(Arrays.toString(getInterests(interests)));

        System.out.println("\nHere is users full information:\n");
        userFullInformation(finalFullName,finalNumber,returnedValueID, getInterests(interests));




    }

}