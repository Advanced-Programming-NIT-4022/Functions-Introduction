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

    }
}

