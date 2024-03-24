package org.example;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static String normalizer(String name)
    {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
    public static String fullName(String firstName, String lastName)
    {
        String resultFirstName = normalizer(firstName);
        String resultLastName = normalizer(lastName);
        return (resultFirstName + " " + resultLastName);

    }
    public static String phoneNumber(String number)
    {
        if(number.length() == 10 && number.charAt(0)=='9')
        {
            return ("0"+number);
        }
        else
        {
            System.out.println("wrong entry. try again");
            phoneNumber(scanner.next());
        }

    }
    public static void main(String[] args)
    {



    }
}