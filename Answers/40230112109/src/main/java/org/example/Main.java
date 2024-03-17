package org.example;

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
        System.out.println("Write your interests & enter \"End\" at the end: ");
        String[] saveInterestsArray = user.getInterests();
        String userFullInformations = user.userFullInformations(saveInterestsArray);
        System.out.println("User's encoded informations: ");
        System.out.println(user.informationEncoder(userFullInformations, 3));
        System.out.print("If you wanna decode them, enter 3 & if you don't, enter \"End\": ");
        String choose = input.nextLine();
        if (choose.equals("End")){
            System.out.println("Have a nice day^^");
            System.exit(0);
        }
        System.out.println("User's decoded informations: ");
        System.out.println(user.informationDecoder(user.informationEncoder(userFullInformations, 3), 3));
    }
}