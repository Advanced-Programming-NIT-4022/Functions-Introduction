package org.example;

import java.util.Scanner;

public class methods {
    public String fullName(String firstName, String lastName) {
        String fullName;
        fullName = firstName.substring(0, 1).toUpperCase();
        fullName = fullName + firstName.substring(1).toLowerCase();

        fullName = fullName + " ";

        fullName = fullName + lastName.substring(0, 1).toUpperCase();
        fullName = fullName + lastName.substring(1).toLowerCase();
        return fullName;
    }

    public String phoneNumber(String phone, Scanner stringScanner) {
        System.out.println("Please enter your phone number: ");
        phone = stringScanner.nextLine();

        while (phone.length() != 10 || phone.charAt(0) != '9') {
            System.out.println("Invalid input!");
            System.out.println("Please enter your phone number: ");
            phone = stringScanner.nextLine();
        }
        phone = 0 + phone;
        return phone;
    }

    public String userId(String studentId, Scanner stringScanner) {
        System.out.println("Please enter your student id: ");
        studentId = stringScanner.nextLine();

        while (studentId.length() < 4 || studentId.length() > 13) {
            System.out.println("Invalid input!");
            System.out.println("Please enter your student id: ");
            studentId = stringScanner.nextLine();
        }
        return studentId;
    }

    public String[] getInterests(String[] interest, Scanner stringScanner) {
        String addMore = "y";

        for (int i = 0; addMore.equalsIgnoreCase("y") && i < 10; i++) {
            System.out.println("please enter your interests: ");
            System.out.print("Interest" + (i + 1) + ": ");
            interest[i] = stringScanner.next();
            System.out.println("would you like to add more interests? (Y/N) ");
            addMore = stringScanner.next();

            while (!(addMore.equalsIgnoreCase("y") || (addMore.equalsIgnoreCase("n")))) {
                System.out.println("Invalid input ");
                System.out.println("would you like to add more interests? (Y/N) ");
                addMore = stringScanner.nextLine();
            }
        }
        return interest;
    }

    public void userFullInformation(String fullName, String studentId, String phone, String[] interest) {
        System.out.print("Hello! My name is " + fullName + ". ");
        System.out.print("My ID is " + studentId + ". ");
        System.out.println("Here are some of my interests: ");

        for (int i = 0; interest[i] != null; i++) {
            System.out.println(i + 1 + "." + interest[i]);
        }

        System.out.println("You can reach me via my phone number: " + phone);

    }

    public void informationEncoder(String sentence) {
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        System.out.println("please enter your sentence: ");
        sentence = stringScanner.nextLine();

        System.out.println("please enter a number: ");
        int shift = intScanner.nextInt();

        char current;
        String encodedText = "";


        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i)==' '||sentence.charAt(i)==','||sentence.charAt(i)=='.'){
                encodedText += sentence.charAt(i);
            }
            else{
            current = sentence.charAt(i);
            int shiftedCodePoint = (current + shift);
            if (shiftedCodePoint>122)
                shiftedCodePoint-=26;
            encodedText += ((char) shiftedCodePoint);
            }
        }

        System.out.println(encodedText);
    }

    public void informationDecoder(String sentence){
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        System.out.println("please enter your sentence: ");
        sentence = stringScanner.nextLine();

        System.out.println("please enter a number: ");
        int shift = intScanner.nextInt();

        char current;
        String decodedText = "";


        for (int i = 0; i < sentence.length(); i++) {
            if(sentence.charAt(i)==' '||sentence.charAt(i)==','||sentence.charAt(i)=='.'){
                decodedText += sentence.charAt(i);
            }
            else{
                current = sentence.charAt(i);
                int shiftedCodePoint = (current - shift);
                if (shiftedCodePoint < 65)
                    shiftedCodePoint+=26;
                if (current >= 'a' && shiftedCodePoint < 97)
                    shiftedCodePoint+=26;

                decodedText += ((char) shiftedCodePoint);
            }
        }

        System.out.println(decodedText);

    }
}