package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String firstName, lastName, phone="null", studentId="null", fullName, sentence="";
        String[] interests = new String[10];

        methods object = new methods();

        Scanner stringScanner = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        firstName = stringScanner.nextLine();

        System.out.println("Please enter your last name: ");
        lastName = stringScanner.nextLine();

        fullName = object.fullName(firstName, lastName);
        phone = object.phoneNumber(phone,stringScanner);
        studentId = object.userId(studentId, stringScanner);
        interests = object.getInterests(interests, stringScanner);

        object.userFullInformation(fullName, studentId, phone, interests);

        System.out.println("would you like to encode a sentence? (y/n)");
        String input = stringScanner.next();

        if(input.equalsIgnoreCase("y")){
            object.informationEncoder(sentence);
        }

        System.out.println("would you like to decode a sentence? (y/n)");
        input = stringScanner.next();
        if(input.equalsIgnoreCase("y")){
            object.informationDecoder(sentence);
        }
    }
}