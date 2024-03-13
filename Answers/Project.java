import java.util.Scanner;

class Userid{
    public static String Idnum() {
        Scanner scr = new Scanner(System.in);
        String id = "";
        while (true) {
            System.out.println("Enter Your IdNumber: ");
            id = scr.nextLine();
            if (id.length() >= 4 && id.length() <= 13 && id.matches("[0-9]+"))
                break;
            else {
                System.out.println("Invalid Id. please enter number between 4 & 13 !");
            }
        }
        return id;
    }
}


public class Project {
        public static boolean isValidPhoneNumber(String phoneNumber) {
            return phoneNumber.matches("^9[0-9]{9}$");
        }
        public static String addZeroToPhoneNumber(String phoneNumber) {
            return "0" + phoneNumber;
        }

        public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("1.Setting Name");
        System.out.println("2.Setting Phone");
        System.out.println("3.Setting Id");
        System.out.println("4.Setting Interests");
        int in = input.nextInt();

        if(in == 1 ){
            Scanner First = new Scanner(System.in);
            System.out.println("Enter The FirstName : ");
            String first = First.nextLine();
            Scanner Last = new Scanner(System.in);
            System.out.println("Enter The LastName : ");
            String last = Last.nextLine();

            String FirstName = first.substring(0,1).toUpperCase()
                    + first.substring(1).toLowerCase();
            String LastName = last.substring(0,1).toUpperCase()
                    + last.substring(1).toLowerCase();
            String FullName = FirstName + " " + LastName;

            System.out.println("saving...");
            System.out.println();
            System.out.println("FullName Is : " + FullName);

            System.out.println();
            System.out.println("2.Setting Phone");
            System.out.println("3.Setting Id");
            System.out.println("4.Setting Interests");

            Scanner input1 = new Scanner(System.in);
            int in1 = input1.nextInt();
            if( in1 == 2){
                Scanner inputphone = new Scanner(System.in);
                String phoneNumber = "";
                boolean isValid = false;

                while (!isValid) {
                    System.out.print("Enter a phone number: ");
                        phoneNumber = inputphone.nextLine();
                            if (isValidPhoneNumber(phoneNumber)) {
                                isValid = true;
                            } else {
                                System.out.println("Invalid phone number." +
                                        " Please enter a 10-digit number starting with 9.");
                            }
                        }

                String modifiedPhoneNumber = addZeroToPhoneNumber(phoneNumber);
                System.out.println("Saving...");
                System.out.println();
                System.out.println("Phone Number: " + modifiedPhoneNumber);

                System.out.println();
                System.out.println("3.Setting Id");
                System.out.println("4.Setting Interests");

                Scanner input2 = new Scanner(System.in);
                int in2 = input2.nextInt();
                if(in2 == 3){
                    Userid stdid = new Userid();
                    String studentid = stdid.Idnum();
                    System.out.println("Saving...");
                    System.out.println();
                    System.out.println("Your Student Id : " + studentid);
                    System.out.println();
                    System.out.println("4.Setting Interests");
                    Scanner input3 = new Scanner(System.in);
                    int in3 = input3.nextInt();

                    if (in3 == 4) {
                        Scanner scrintr = new Scanner(System.in);
                        System.out.println("Enter Your Interests In Your Free Time: ");
                        String[] interests = new String[10];

                        for (int i = 0; i < 10; i++) {
                            interests[i] = scrintr.nextLine();
                        }
                        System.out.println("Saving...");
                        System.out.println();
                        System.out.println("Your Interests:");
                        for (String interest : interests)
                            if (interest != null && !interest.isEmpty())
                                System.out.println(interest);


                        }
                    }
                }
            }
        }
}



