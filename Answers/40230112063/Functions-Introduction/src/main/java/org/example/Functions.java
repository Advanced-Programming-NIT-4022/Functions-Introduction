package org.example;

import java.util.Objects;

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


}