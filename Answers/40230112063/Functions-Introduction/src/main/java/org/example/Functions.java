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

    public String phoneNumber(String phone)
    {
        //If the input phone number is valid, it returns the phone number
        //otherwise returns 0.

        if(phone.length()==11 && phone.startsWith("0") && phone.substring(1).startsWith("9"))
            return phone;

        else if(phone.length()==10 && phone.startsWith("9"))
        {
            phone = "0".concat(phone);
            return phone;
        }
        else
            return "0";
    }

    public String userId(String id)
    {
        //if input id is in correct form , it returns id
        //otherwise returns 0

        if(4<=id.length() && id.length()<=13)
            return id;
        else
            return "0";
    }

    public void getInterests(String[] interests)
    {
        String operation ;

        int counter=0;

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
                    return;

                default :
                    System.out.println("Wrong entry . Try again . ");
            }
        }
    }


    public String userFullInformation(String full_name , String phone_number , String user_id , String[] interests)
    {
        String full_information ;
        String str_interests="";

        int interests_size=0 ;

        for(String i : interests)
            if(Objects.equals(i, null))
                break;
            else
                interests_size++;


        for(int i=0 ; i<interests_size-1 ; i++)
        {
            str_interests = str_interests.concat(interests[i]).concat("-");
        }

        str_interests = str_interests.concat(interests[interests_size-1]);

        full_information = "Hello Dear , My name is ".concat(full_name).concat(".\n")
                .concat("My ID is ").concat(user_id).concat(".\n")
                .concat("Here are some of my interests : \n")
                .concat(str_interests)
                .concat("\nYou can be in touch with me by ").concat(phone_number);

        return full_information;
    }

    public String informationEncoder(String information, int shift)
    {
        String[] information_array = information.split("");
        String encoded_info;
        char tmp;

        for(String i : information_array)
        {
            tmp = i.charAt(0); // casting String i to char i

            if('a'<=tmp && tmp<='z')
            {
                i = (tmp+shift>(int)'z') ? String.valueOf((char)(tmp+shift-26)) : String.valueOf((char)(tmp+shift));
            }
            else if('A'<=tmp && tmp<='Z')
            {
                i = (tmp+shift>(int)'Z') ? String.valueOf((char)(tmp+shift-26)) : String.valueOf((char)(tmp+shift));
            }
            else if('0'<=tmp && tmp<='9')
            {
                i = (tmp+shift>(int)'9') ? String.valueOf((char)(tmp+shift-10)) : String.valueOf((char)(tmp+shift));
            }
        }

        encoded_info="";

        for(String i : information_array)
            encoded_info = encoded_info.concat(i);

        return encoded_info;
    }

    public String informationDecoder(String information, int shift)
    {
        String[] information_array = information.split("");
        String decoded_info;
        char tmp;

        for(String i : information_array)
        {
            tmp = i.charAt(0); // casting String i to char i

            if('a'<=tmp && tmp<='z')
            {
                i = (tmp-shift<(int)'a') ? String.valueOf((char)(tmp-shift+26)) : String.valueOf((char)(tmp-shift));
            }
            else if('A'<=tmp && tmp<='Z')
            {
                i = (tmp-shift<(int)'A') ? String.valueOf((char)(tmp-shift+26)) : String.valueOf((char)(tmp-shift));
            }
            else if('0'<=tmp && tmp<='9')
            {
                i = (tmp-shift<(int)'0') ? String.valueOf((char)(tmp-shift+10)) : String.valueOf((char)(tmp-shift));
            }
        }

        decoded_info="";

        for(String i : information_array)
            decoded_info = decoded_info.concat(i);

        return decoded_info;
    }
}
