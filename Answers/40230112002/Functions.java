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

    public static String userId(String id){
        if(id.length()<13 && id.length()>4){
            return id;
        }
        else{
            System.out.println("Error : Invalid ID (ID should be between 4 and 13 digits \n Try Again ... \n Enter a valid ID : ");
            return "Error";
        }
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
    }
}