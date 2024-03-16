package org.example;

import java.util.Scanner;
import java.util.Objects;

public class ResumeMaker {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Functions person1 = new Functions();

        String firstname, lastname, fullname, information;
        String phone, id;

        String[] interests = new String[10];


        System.out.println("Enter your first name : ");
        firstname = input.nextLine();

        System.out.println("Enter your last name : ");
        lastname = input.nextLine();

        fullname = person1.fullName(firstname, lastname);

        while (true) // phone number
        {
            System.out.println("Enter your phone number : ");
            phone = input.nextLine();
            phone = person1.phoneNumber(phone);

            if (Objects.equals(phone, "0")) // 0 : It means that the user has entered a phone number with the wrong format
            {
                System.out.println("Wrong entry. Try again.");
            } else
                break;
        }

        while (true) // user id
        {
            System.out.println("Enter your student id : ");
            id = input.nextLine();

            id = person1.userId(id);

            if (Objects.equals(id, "0")) // 0 : It means that the user has entered  ID with the wrong format
            {
                System.out.println("Wrong entry. Try again.");
            } else
                break;
        }

        person1.getInterests(interests); // get interests

        information = person1.userFullInformation(fullname, phone, id, interests);

        String operation;
        int shift;

        System.out.println("How many shift units do you want to be given in Caesar encryption ? ");
        shift = input.nextInt();
        input.nextLine();

        while (true) {
            System.out.println("Select your desired operation : ");
            System.out.println("SEI - Show me encoded information");
            System.out.println("SDI - Show me decoded information");
            System.out.println("E - Exit");

            operation = input.nextLine();
            switch (operation) {
                case "SEI":
                    information = person1.informationEncoder(information, shift);
                    System.out.println(information);
                    break;

                case "SDI":
                    System.out.println(person1.informationDecoder(information, shift));
                    break;

                case "E":
                    System.out.println("Bye :-) ");
                    return;

                default:
                    System.out.println("Wrong entry . Try again . ");
            }
        }

    }
}

