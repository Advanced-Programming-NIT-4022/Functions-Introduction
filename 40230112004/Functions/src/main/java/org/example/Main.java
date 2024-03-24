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

    public static void main(String[] args)
    {



    }
}