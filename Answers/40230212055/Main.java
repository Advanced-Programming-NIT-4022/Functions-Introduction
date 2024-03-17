package tamrin2_AP;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


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
            return phonenumber();
        }



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


    public static String information1(String fullname, String phonenumber, String ID, String[] interests) {


        String str = "Hello! My name is ";

        str += fullname;
        str += ".";
        str += "My ID is ";
        str += ID;
        str += ".";
        str += "Here are some of my interest:";
        str += "#";

        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
        }

        System.out.println("Hello! My name is " + fullname + "." + "My ID is " + ID + "." + "Here are some of myinterest:" + "\n");

        for (int i = 0; i < interests.length; i++)
        {
            System.out.println((i + 1) + " : " + interests[i]);

                str += interests[i];
                str += "#";

        }

        // baraye mark kardan

        System.out.println("\n" + "You can reach me via my phone number " + phonenumber + " ." + "\n");

        str += "You can reach me via my phone number " ;
        str += phonenumber+".";
        str += "#";




        return str;

        //Hello! My name is Aryan Nourbakhsh. My ID is 40030111111. Here are some of my interests:

    }


    public static String EnCodeInformation(String stringinput)
    {

        System.out.print("shift : ");
        Scanner inputshift = new Scanner(System.in);
        int shift = inputshift.nextInt();


        char[] sentence = stringinput.toCharArray();
        int asci;

        for (int i=0 ; i<sentence.length ; i++)
        {

            asci = sentence[i];


            if ((asci+shift)>=65 && (asci+shift)<=90)
            {
                sentence[i] = (char)(asci+shift);
            }

            else if ((asci+shift)>90 && (asci+shift)<=122)
            {
                if (asci<=90)
                {
                    sentence[i]=(char) (64+((asci+shift)-90));
                }
                else if (asci>90)
                {
                    sentence[i]=(char)(asci+shift);
                }

            }

            else if ((asci+shift)>=97 && (asci+shift)<=122)
            {
                sentence[i]=(char) asci;
            }

            else if ((asci+shift)>122 )
            {
                sentence[i]=(char) (96+((asci+shift)-122));
            }


        }

        //for (int i=1 ; i< sentence.length ; i++)
        {
            //sentence[0]+=sentence[i];
        }

        //System.out.println(sentence[0]);

        String str = String.valueOf(sentence);

        return str;
    }


    public static void main(String[] args) {


        String userfullname = "0";
        String usernumber = "0";
        String userID = "0";
        String[] userinterests = {"0"};
        String stringinformation ;


        userfullname = fullname();
        System.out.println("\n");


        usernumber = phonenumber();
        System.out.println("\n");

        userID = userid();
        System.out.println("\n");


        userinterests = interests();
        System.out.println("\n");


        stringinformation = information1(userfullname, usernumber, userID, userinterests);



        while (true)
        {
            System.out.println("Encode information    (1) ");
            System.out.println("Decode information    (2) ");
            System.out.println("show   information    (3) ");
            System.out.println("EXIT                  (4) ");
            System.out.print  ("choose a option : "        );

            Scanner input = new Scanner (System.in);
            int switchkey = input.nextInt();





            switch (switchkey)
            {

                case 1:

                    stringinformation = EnCodeInformation(stringinformation);
                    continue;

                case 2:



                case 3:

                    String [] show = stringinformation.split("#");

                    System.out.println("\n" + show[0]);

                    for (int i=1 ; i<=show.length-2 ; i++)
                    {
                        System.out.println((i) + " : " + show[i]);
                    }

                    System.out.println(show[show.length-1] + "\n");

                    System.out.print("enter (exit) for back : ");
                    Scanner stop = new Scanner(System.in);
                    String stop2 = stop.nextLine();
                    System.out.println("\n");

                    continue;

                case 4:
                    break;

            }
        }




    }
}


