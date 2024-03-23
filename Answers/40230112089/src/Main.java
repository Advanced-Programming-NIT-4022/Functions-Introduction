import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.ArrayList;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Scanner scStr = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);




        System.out.println("Please enter your first name:");
        String fName = scStr.nextLine();
        System.out.println("Please enter your last name:");
        String lName = scStr.nextLine();

        Functions functions = new Functions();

        String userFullName = functions.fullName(fName, lName);
        System.out.println(userFullName);


        System.out.println("Please enter your phone number:");

        boolean invalid =true;
        String userPhoneNumber = "";
        while(invalid) {
            String phoneNumber = scInt.nextLine();
             userPhoneNumber = functions.phoneNumber(phoneNumber);
            System.out.println(userPhoneNumber);
            if (userPhoneNumber !="Wrong entry. Try again."){
                invalid = false;
            }
            }




        System.out.println("Please Enter your student ID:");
        invalid =true;

        String userId ="";
        while(invalid) {
            String id = scStr.nextLine();

             userId = functions.userId(id);
            System.out.println(userId);
            if (userId !="Wrong entry. Try again."){
                invalid = false;
            }
        }



        System.out.println("Please enter some of your interests: \n(the maximum number of your interests can be 10 and press an extra ENTER button to finish.)");

        ArrayList<String> interests = new ArrayList<>();
        for (int i=0;i<10;i++){
            String interest = scStr.nextLine();
            if (interest.isEmpty()){
                break;
            }
            else{
                interests.add(interest);
            }

        }
        StringBuilder userInterests = functions.getInterests(interests) ;
        System.out.println(userInterests);


        StringBuilder userFullInformation = functions.userFullInformation(userFullName, userPhoneNumber, userId, interests);





        System.out.println("Please enter information for encode: ");
        String Information1 = scStr.nextLine();
        System.out.println("Please enter the number of shifts:");
        int shift1 = scInt.nextInt();

        String informationEncoder = functions.informationEncoder(Information1 , shift1);
        System.out.println(informationEncoder);



        System.out.println("Please enter encode information to decode: ");
        String Information2 = scStr.nextLine();
        System.out.println("Please enter the number of shifts:");
        int shift2 = scInt.nextInt();

        String informationDecoder = functions.informationDecoder(Information2 , shift2);
        System.out.println(informationDecoder);


        String encodedInformation = functions.informationEncoder(userFullInformation.toString() , 3);
        while (true){
            System.out.println("Please select an option :");
            System.out.println("1. show encoded information");
            System.out.println("2. show decoded information");
            System.out.println("3. exit");
            String choice = scStr.nextLine();
            switch (choice){
                case "1" :
                   System.out.println(encodedInformation);
                    break;
                case "2" :
                    System.out.println(functions.informationDecoder(encodedInformation , 3));
                    break;
                case "3" :
                    System.out.println("Bye :)");
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
            }
        }


    }


}