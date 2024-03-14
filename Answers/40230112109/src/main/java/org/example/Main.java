package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResumeMaker user = new ResumeMaker();
        Scanner input = new Scanner(System.in);
        user.setFirstName(input.nextLine());
        user.setLastName(input.nextLine());
        System.out.print(user.fullName(user.getFirstName(), user.getLastName()));
    }
}