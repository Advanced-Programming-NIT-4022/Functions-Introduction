import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    // fullName Function
    public static String fullName(String firstName , String lastName){

        firstName = firstName.toLowerCase();
        String[] firstname = firstName.split("");
        firstname[0] = firstname[0].toUpperCase();
        String Firstname = String.join("" , firstname);

        lastName = lastName.toLowerCase();
        String[] lastname = lastName.split("");
        lastname[0] = lastname[0].toUpperCase();
        String Lastname = String.join("" , lastname);

        return Firstname+" "+Lastname;
    }
    //Phone Function
    public static String Phone(String phone) {

        String[] phoneNumbers = phone.split("");
            if(phoneNumbers[0].equals("9") && phoneNumbers.length == 10){
                phone = "0" + phone;
                return phone;
            }
            else{
                System.out.println("Error : Invalid Phone number !! \n Try Again ... \n Enter a valid Phone number : ");
                return "Error";
            }
    }
    //userId function
    public static String userId(String id){
        if(id.length()<13 && id.length()>4){
            return id;
        }
        else{
            System.out.println("Error : Invalid ID (ID should be between 4 and 13 digits \n Try Again ... \n Enter a valid ID : ");
            return "Error";
        }
    }
    //getInterests Function
    public static ArrayList<String> getInterests(String interest){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ListOfInterest = new ArrayList<>();
        ListOfInterest.add(interest);
        for(int i = 0 ; i < 9 ; i++){
           System.out.println("Input : ");
           interest = sc.nextLine();
           if(interest.equals("0")){
               return ListOfInterest;
           }
           ListOfInterest.add(interest);
        }
        return ListOfInterest;

    }


    //userFullInformation Function
    public static void userFullInformation(String fullName, String phoneNumber, String userID, ArrayList<String> interests){
        System.out.println("Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests:");
        for(int i = 0 ; i < interests.size() ; i++){
            System.out.println((i+1) +". "+interests.get(i));
        }
        System.out.println("\n\nYou can reach me via my phone number " +phoneNumber+".");
    }

    public static void main(String[] args) {

        //getting name from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your firstname : ");
        String firstname = sc.next();
        System.out.println("Enter your lastname : ");
        String lastname = sc.next();
        String Fullname = fullName(firstname, lastname);

        //getting phone number from user
        System.out.println("Enter a valid Phone number : ");
        String phone;

        while (true) {
            phone = sc.next();
            if (!Phone(phone).equals("Error")) {
                phone = Phone(phone);
                break;
            }
        }

        //validating user id
        System.out.println("Enter a valid ID : ");
        String id;
        do {
            id = sc.next();
        } while (userId(id).equals("Error"));

        //getting user interests
        String interest;
        System.out.println("Enter your interests : \n (Enter \"0\" to stop)");
        System.out.println("Input : ");
        sc.nextLine(); // just for passing the \n in scanner
        interest = sc.nextLine();
        ArrayList<String> ListOfInterest = getInterests(interest);

        //showing user info
        userFullInformation(Fullname , phone , id , ListOfInterest);

        //Encoding
        String Information = "Hello"; //just for testing the cipher
        System.out.println("Do you want to Encode this information? Y/N");
        String Input = sc.nextLine();
        if(Input.equals("Y") || Input.equals("y")){
            System.out.println("Enter the Shift : ");
            int shift = sc.nextInt();
            String EncodedInfo = Cipher.Encoding(Information , shift);
            System.out.println("Encoded Info: \n" + EncodedInfo);
        }
        }
    }