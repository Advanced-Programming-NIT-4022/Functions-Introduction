package org.example;

import java.util.Objects;
import java.util.Scanner;

public class Functions
{
    public String fullName(String firstName , String lastName)
    {
        //normalizing firstName
        int size1 = firstName.length();
        if('a'<=firstName.charAt(0) && firstName.charAt(0)<='z')
            firstName = (char)(firstName.charAt(0)-32) + firstName.substring(1);


        for(int i=1 ; i<size1-1 ; i++)
        {
            if('A'<=firstName.charAt(i) && firstName.charAt(i)<='Z')
                firstName = firstName.substring(0,i-1+1) + (char)(firstName.charAt(i)+32) + firstName.substring(i+1);
        }

        if('A'<=firstName.charAt(size1-1) && firstName.charAt(size1-1)<='Z')
            firstName = firstName.substring(0,size1-2+1) + (char)(firstName.charAt(size1-1)+32);


        //normalizing lastName
        int size2 = lastName.length();
        if(lastName.equals(" "))
            return (firstName);

        if('a'<=lastName.charAt(0) && lastName.charAt(0)<='z')
            lastName = (char)(lastName.charAt(0)-32) + lastName.substring(1);


        for(int i=1 ; i<size2-1 ; i++)
        {
            if('A'<=lastName.charAt(i) && lastName.charAt(i)<='Z')
                lastName = lastName.substring(0,i-1+1) + (char)(lastName.charAt(i)+32) + lastName.substring(i+1);
        }

        if('A'<=lastName.charAt(size2-1) && lastName.charAt(size2-1)<='Z')
            lastName = lastName.substring(0,size2-2+1) + (char)(lastName.charAt(size2-1)+32);

        if(Objects.equals(firstName, " "))
            return lastName;

        return (firstName+" "+lastName);
    }

    public int phoneNumber(Integer phone)
    {
        //If the input phone number is valid, it returns the phone number
        //otherwise returns 0.

        String number_str = phone.toString();

        if(number_str.length()==11 && number_str.startsWith("0") && number_str.substring(1).startsWith("9"))
            return phone;

        else if(number_str.length()==10 && number_str.startsWith("9"))
        {
            number_str = "0".concat(number_str);

            phone = 0;
            for(int i=0 ; i<number_str.length() ;i++)
            {
                phone = phone*10 + (number_str.charAt(i)-48);
            }

            return phone;
        }
        else
            return 0;
    }

    public int userId(Integer id)
    {
        //if input id is in correct form , it returns id
        //otherwise returns 0
        String id_str = id.toString();

        if(4<=id_str.length() && id_str.length()<=13)
            return id;
        else
            return 0;
    }

    public void getInterests(String[] interests)
    {
        String operation ;

        int counter=0;

        boolean flag = false;

        Scanner input = new Scanner(System.in);

        while(true)
        {
            System.out.println("Select your desired operation : ");
            System.out.println("NI - New Interest");
            System.out.println("E - Exit");

            operation = input.nextLine();

            switch (operation)
            {
                case "NI" :
                    System.out.println("Enter your interest : ");
                    interests[counter]=input.nextLine();
                    counter++;
                    break;

                case "E" :
                    flag = true;
                    break;

                default :
                    System.out.println("Wrong entry . Try again . ");
            }

            if(flag)
                break;
        }
    }


    public void userFullInformation(String full_name , int phone_number , int user_id , String[] interests)
    {
        System.out.println("Full Name : "+full_name);
        System.out.println("Phone Number : "+phone_number);
        System.out.println("User ID : "+user_id);
        System.out.println("Some of my interests : ");
        for(int i=0 ; i<interests.length ; i++)
        {
            System.out.println(i+1 + "." + interests[i]);
        }
        System.out.println("You can be in touch with me by my phone number \n"+phone_number);
    }

    public String informationEncoder(String information, int shift)
    {
        String[] information_array = information.split("");
        char tmp;

        for(String i : information_array)
        {
            tmp = i.charAt(0); // casting String i to char i

            if('a'<=tmp && tmp<='z')
            {
                tmp = (tmp+shift>(int)'z') ? (char)(tmp+shift-26) : (char)(tmp+shift);
            }
            else if('A'<=tmp && tmp<='Z')
            {
                tmp = (tmp+shift>(int)'Z') ? (char)(tmp+shift-26) : (char)(tmp+shift);
            }
        }

        information="";

        for(String i : information_array)
            information = information.concat(i);

        return information;
    }

}
