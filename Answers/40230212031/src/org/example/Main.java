package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        Functions functions = new Functions();
        String normalizedName = functions.normalizingName(firstName, lastName);

        System.out.println("Normalized name: " + normalizedName);
//////////////////////////////////////////////////////////////////////
      
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        while (!functions.checking(phone)) {
            //اگر شماره وارد شده توسط کاربر صحیح نبود
            System.out.println("Wrong entry. Try again.");
            System.out.print("Enter phone number: ");
            phone = scanner.nextLine();
            //دریافت مجدد شماره توسط کاربر
        }

        String formattedPhone = functions.formatPhoneNumber(phone);
        //در اینجا شماره قطغا درسته و به کاربر نمایش داده میشود
        System.out.println("Output: " + formattedPhone);


    }
}

