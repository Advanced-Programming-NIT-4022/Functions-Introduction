package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Class01 class01 = new Class01();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        boolean Variable1 = true;
        boolean Variable = true;
        System.out.print("Please enter your first name:");
        String firstName = input.nextLine();
        System.out.print("Please enter your last name:");
        String lastName = input.nextLine();

        String number = "";
        while (Variable) {
            System.out.print("Please enter your mobile phone number: ");
            number = input.nextLine();
            int Number1 = number.length();
            if (Number1 == 10 || Number1 == 11) {
                Variable = false;
            } else {
                class01.phoneNumber(number);
            }
        }

        String id = "";
        while (Variable1) {
            System.out.print("Please enter your ID: ");
            id = input.nextLine();
            int Number2 = id.length();
            if (Number2 < 13 && 4 < Number2) {
                Variable1 = false;
            } else {
                System.out.println(class01.userID(id));
            }
        }

        System.out.println("**In this section, you can write your favorite activities**" + "\n");
        System.out.println("First, determine the number of your activities(note that you can write a maximum of 10)" + "\n");
        System.out.print("Please enter the desired number: ");
        int Number3 = input2.nextInt();
        String[] str = new String[Number3];
        for (int i = 0; i < Number3; i++) {
            System.out.print((i+1) + "-");
            str[i] = input.nextLine();
        }


        String text = "Hello! My name is ";
        String text1 = "My ID is ";
        String text2 = "Here are some of my interests:";
        String text3 = "You can reach me via my phone number ";
        int shift = 3;
        String result = class01.encrypt(text, 3);
        String result1 = class01.encrypt(text1, 3);
        String result2 = class01.encrypt(text2, 3);
        String result3 = class01.encrypt(text3, 3);
        String result4 = class01.encrypt(class01.fullName(firstName, lastName), 3);
        String result5 = class01.encrypt(class01.getinterests(str, Number3), 3);

        System.out.println("Do you want to see the information encrypted or normal?");
        System.out.println("1-Encrypted" + "\n" + "2-Normal" + "\n" + "3-Exit the program");
        System.out.print("Please enter your desired option:");
        int answer = input.nextInt();
        switch (answer) {
            case 1:
                System.out.print(result);
                System.out.print(result4);
                System.out.println(".");
                System.out.print(result1);
                System.out.println(class01.conversion2(id));
                System.out.println(result2);
                System.out.println(result5);
                System.out.print(result3);
                System.out.println(class01.conversion1(number));
                break;


            case 2:
                System.out.print("Hello! My name is ");
                System.out.print(class01.fullName(firstName, lastName));
                System.out.println(".");
                System.out.print("My ID is ");
                System.out.println(class01.userID(id));
                System.out.println("Here are some of my interests:");
                System.out.println(class01.getinterests(str, Number3));
                System.out.print("You can reach me via my phone number ");
                class01.phoneNumber(number);
                break;
            case 3:
                break;
        }
    }
}