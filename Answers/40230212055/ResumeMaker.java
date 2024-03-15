package tamrin1_AP;

import java.util.Scanner;

public class ResumeMaker {


    public static String fullname() {


        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.print("enter first name : ");
        String firstname = input1.nextLine();
        System.out.print("enter last name : ");
        String lastname = input2.nextLine();

        String[] name1 = firstname.split("");
        String[] name2 = lastname.split("");

        name1[0] = name1[0].toUpperCase();
        name2[0] = name2[0].toUpperCase();

        for (int i = 1; i < name1.length; i++) {
            name1[i] = name1[i].toLowerCase();
            name1[0] += name1[i];
        }

        for (int i = 1; i < name2.length; i++) {
            name2[i] = name2[i].toLowerCase();
            name2[0] += name2[i];
        }

        name1[0] += " ";
        name1[0] += name2[0];
        System.out.println("Full name : " + name1[0]);


        return name1[0];
    }


    public static String phonenumber() {


        System.out.print("enter phune number(must be 11 digit) : ");

        Scanner input = new Scanner(System.in);
        String number1 = input.nextLine();
        String[] number = number1.split("");


        if (number.length == 11) {

            for (int i = 1; i <= 10; i++) {
                number[0] += number[i];
            }

            System.out.print("phone number : " + number[0]);

            return number[0];

        } else if (number[0] != "0" && number.length == 10) {

            String str = "0";

            for (int i = 0; i < number.length; i++) {
                str += number[i];
            }

            System.out.print("phone number : " + str);

            return str;

        } else {
            System.out.println("Wrong entry. Try again (enter (0)) : ");
            phonenumber();
        }


        return " not found ";

    }


    public static String[] interests() {


        System.out.print("number of interest : ");
        Scanner input = new Scanner(System.in);
        int limit = input.nextInt();

        String[] interest = new String[limit];

        for (int i = 0; i < limit; i++) {

            System.out.print("interest " + (i + 1) + " : ");

            Scanner input2 = new Scanner(System.in);
            interest[i] = input2.nextLine();


        }

        System.out.println("your interests list : ");

        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + " : " + interest[i]);
        }

        return interest;
    }


    public static String userid() {

        System.out.print("enter ID : ");

        Scanner input = new Scanner(System.in);
        String id = input.nextLine();

        System.out.println("you ID : " + id);

        return id;
    }


    public static void information1(String fullname, String phonenumber, String ID, String[] interests) {

        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
        }

        System.out.println("Hello! My name is " + fullname + "." + "My ID is " + ID + "." + "Here are some of myinterest:" + "\n");

        for (int i = 0; i < interests.length; i++) {
            System.out.println((i + 1) + " : " + interests[i]);
        }

        System.out.println("\n" + "You can reach me via my phone number " + phonenumber + " .");

        //Hello! My name is Aryan Nourbakhsh. My ID is 40030111111. Here are some of my interests:

    }


    public static int option() {


        System.out.println("enter first name & last name : (1) ");
        System.out.println("enter phone number           : (2) ");
        System.out.println("enter user ID                : (3) ");
        System.out.println("enter interests              : (4) ");
        System.out.println("show information             : (5) ");

        System.out.print("choose a option : ");
        Scanner input = new Scanner(System.in);
        int switchkey = input.nextInt();

        return switchkey;

    }


    public static void main(String[] args) {


        String userfullname = "0";
        String usernumber = "0";
        String userID = "0";
        String[] userinterests = {"0"};


        userfullname = fullname();
        System.out.println("\n");


        usernumber = phonenumber();
        System.out.println("\n");

        userID = userid();
        System.out.println("\n");


        userinterests = interests();
        System.out.println("\n");


        information1(userfullname, usernumber, userID, userinterests);


    }
}


