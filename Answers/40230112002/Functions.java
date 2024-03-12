
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
    /*
    this function could have print out the info and also get the standard output of console
    by using the ByteArrayOutputStream class and PrintStream class and return this info
    to the encoder function
    Also the Loop for concatenation could have used StringBuilder class to append the items of the Array
    But I Continued using the normal method to avoid complications
     */

    public static String userFullInformation(String fullName, String phoneNumber, String userID, ArrayList<String> interests){
//        ByteArrayOutputStream Information = new ByteArrayOutputStream();
//        PrintStream ps = new PrintStream(Information);
//        PrintStream old = System.out;
//        System.setOut(ps);

        String Information;
        Information = "Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests:";
        for(int i = 0 ; i < interests.size() ; i++){
            Information= Information+"\n"+ (i+1) +". "+interests.get(i);
        }
        Information= Information + "\nYou can reach me via my phone number " +phoneNumber+".";

//        System.out.flush();
//        System.setOut(old);
//        return Information.toString();
        return Information;
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

        //showing user info and getting the standard output for encoding the information
        String Information = userFullInformation(Fullname , phone , id , ListOfInterest);

        //Encoding
        System.out.println("1.Show Encoded Information\n2.Show Decoded Information\nInput: ");
        String Input = sc.nextLine();
        System.out.println("Enter the Shift to Encode Info : ");
        int shift = sc.nextInt();
        String EncodedInfo = Cipher.Encoder(Information, shift);

        //Info has been encoded up tp this point
        if(Input.equals("1")) {
            System.out.println("Encoded Info: \n" + EncodedInfo);
        }
        //Decoding
        //the Decoder only shifts back
        else{
            String DecodedInfo = Cipher.Decoder(EncodedInfo , shift);
            System.out.println("Decoded Info: \n"+ DecodedInfo);
            }
        }

}