package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResumeMaker user = new ResumeMaker();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your firstname please: ");
        user.setFirstName(input.nextLine());
        System.out.print("Enter your lastname please: ");
        user.setLastName(input.nextLine());
        System.out.print("Enter your phone number please: ");
        user.setPhone(input.nextLine());
        while (user.phoneNumber(user.getPhone()).equals("Error!")){
            System.out.print("Wrong entry. Try again: ");
            user.setPhone(input.nextLine());
        }
        System.out.print("Enter your user ID please: ");
        user.setId(input.nextLine());
        while(user.userId(user.getId()) == 1){
            System.out.println("Wrong entry. Try again: ");
            user.setId(input.nextLine());
        }

        System.out.println("Write your interests & enter \"End\" at the end.");
        String[] saveInterestsArray = user.getInterests();
        System.out.println( "Full name: " + user.fullName(user.getFirstName(), user.getLastName()));
        System.out.println("Phone number: " + user.phoneNumber(user.getPhone()));
        System.out.println("User ID: " + user.userId(user.getId()));
        System.out.println("User's interests: " + Arrays.toString(saveInterestsArray));
    }
}